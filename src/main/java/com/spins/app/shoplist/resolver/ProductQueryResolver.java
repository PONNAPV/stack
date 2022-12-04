package com.spins.app.shoplist.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import com.spins.app.shoplist.model.Product;
import com.spins.app.shoplist.repository.ProductRepository;

@Slf4j
@AllArgsConstructor
@Component
public class ProductQueryResolver implements GraphQLQueryResolver{
    private ProductRepository productRepository;

    public Optional<Product> getProduct(final String productId){
        log.info("Get Product with Id: {}", productId);
        return productRepository.findById(productId);
    }
    public List<Product> getProducts(){
        log.info("Get all Products");
        return productRepository.findAll();
    }
}
