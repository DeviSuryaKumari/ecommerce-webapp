package com.cloud.project.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Product {
    private Long productId;
    private String name;
    private String description;
    private float price;
    private int quantityAvailable;
    private Long sellerId;
}
