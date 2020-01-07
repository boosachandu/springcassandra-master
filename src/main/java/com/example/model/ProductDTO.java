package com.example.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class ProductDTO {

    private UUID id;
    private String description;
    private BigDecimal price;
    private String imageUrl;

    public ProductDTO() {
        id = UUID.randomUUID();
    }
}
