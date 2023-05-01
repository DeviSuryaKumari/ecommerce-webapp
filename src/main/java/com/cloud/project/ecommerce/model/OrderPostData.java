package com.cloud.project.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter @Setter
public class OrderPostData {
    private Order order;
    private Map<Integer, Integer> productIdAndQuantityMap;
}
