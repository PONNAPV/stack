package com.spins.app.shoplist.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.spins.app.shoplist.model.Product;
import com.spins.app.shoplist.repository.ProductRepository;
import graphql.GraphQLException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import com.spins.app.shoplist.model.Slist;
import com.spins.app.shoplist.repository.SlistRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@AllArgsConstructor
@Component
public class SlistMutationResolver implements GraphQLMutationResolver{
    private SlistRepository slistRepository;
    private ProductRepository productRepository;

    public Slist addSlist(final String name){
        log.info("Add shopping list with name: {}",name);
        return slistRepository.save(Slist.builder().slistName(name).build());
    }
    public Slist addProductToSlist(final String slistId, final String productId){
        log.info("Add product with id: {} to the shopping list id: {}",productId, slistId);
        Optional<Product> product = productRepository.findById(productId);
        Optional<Slist> slist = slistRepository.findById(slistId);
        if (product.isPresent() && slist.isPresent()){
            Set<Product> products = slist.get().getProducts();
           //TODO create a new instance of products set if its null
            if (products == null){
                products = new HashSet<Product>();
            }
            products.add(product.get());
            slist.get().setProducts(products);
            return slistRepository.save(slist.get());
        } else {
            throw new GraphQLException("Couldn't add Product");
        }
    }

    public Slist removeProductFromSlist(final String slistId, final String productId){
        log.info("Remove product with id: {} from the shopping list id: {}",productId, slistId);
        boolean removed = false;
        int productIndex;
        Optional<Slist> slist = slistRepository.findById(slistId);
        //Optional<Product> product = Optional.ofNullable(slistRepository.findByProductsProductId(productId));
        Product removeProduct = productRepository.findById(productId).get();
        if (removeProduct != null && slist.isPresent()){
            Set<Product> products = slist.get().getProducts();
            productIndex = getIndex(products,removeProduct);
            if(productIndex >= 0){
                removed = products.remove(removeProduct);
                if (removed) {
                    slist.get().setProducts(products);
                }
            } else {
                log.info("Product ID: {} : was not removed from the shopping list ID: {}",productId,slistId);
            }
            return slistRepository.save(slist.get());
        } else {
            log.info("Product ID: {} in the list or Slist ID: {} is not available",productId, slistId);
            throw new GraphQLException("Couldn't add Product");
        }
    }
    public static <T> int getIndex(Set<T> set, T value) {
        int result = 0;
        for (T entry:set) {
            if (entry.equals(value)) return result;
            result++;
        }
        return -1;
    }
}
