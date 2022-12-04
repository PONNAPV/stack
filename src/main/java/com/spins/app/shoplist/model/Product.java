package com.spins.app.shoplist.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class Product {
    @Id
    private String productId;
    private String productName;
    private Float unitPrice;
}
