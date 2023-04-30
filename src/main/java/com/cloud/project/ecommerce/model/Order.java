package com.cloud.project.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Order {
    private enum ORDER_STATUS {PLACED, PROCESSING, DELIVERED;};

    private Long orderId;
    private Long userId;
    private String orderDate;
    private ORDER_STATUS orderStatus;
    private double totalPrice;
}
