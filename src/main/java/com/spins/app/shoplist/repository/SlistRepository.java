package com.spins.app.shoplist.repository;


import com.spins.app.shoplist.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.spins.app.shoplist.model.Slist;

public interface SlistRepository extends MongoRepository<Slist, String> {
    Product findByProductsProductId(String productId);

}
