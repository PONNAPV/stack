package com.spins.app.shoplist.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import  com.spins.app.shoplist.model.Product;

public interface ProductRepository extends  MongoRepository<Product, String>{
}
