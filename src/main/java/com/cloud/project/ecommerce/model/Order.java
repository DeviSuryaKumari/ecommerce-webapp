package com.cloud.project.ecommerce.model;

import com.cloud.project.ecommerce.CONSTANTS;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Order {

    private Integer orderId;
    private Integer userId;
    private String orderDate;
    private CONSTANTS.ORDER_STATUS orderStatus;
    private double totalPrice;
}
