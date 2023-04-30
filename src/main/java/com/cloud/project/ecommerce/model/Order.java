package com.cloud.project.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Order {
    private Long orderId;
    private Long userId;
    private String orderDate;
    private enum ORDER_STATUS {PLACED, PROCESSING, DELIVERED;};
    private double totalPrice;
}
