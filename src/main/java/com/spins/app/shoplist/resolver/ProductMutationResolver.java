package com.spins.app.shoplist.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import com.spins.app.shoplist.model.Product;
import com.spins.app.shoplist.repository.ProductRepository;

@Slf4j
@AllArgsConstructor
@Component
public class ProductMutationResolver implements GraphQLMutationResolver {
    private ProductRepository productRepository;

    public Product addProduct(final String name, final Float price){
        log.info("Add product: {}, {}",name, price);
        return productRepository.save( Product.builder().productName(name).unitPrice(price).build());
    }
}
