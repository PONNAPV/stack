package com.spins.app.shoplist.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import java.util.Set;

@Data
@Builder
public class Slist {
    @Id
    private String slistId;
    private String slistName;
    private Float totalPrice;
    private Set<Product> products;
}
