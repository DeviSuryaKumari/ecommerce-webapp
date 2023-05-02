/* SJSU CS 218 Spring 2023 TEAM6 */
package com.cloud.project.ecommerce.repository;

import com.cloud.project.ecommerce.model.Order;

import java.util.List;
import java.util.Map;

public interface OrderRepository {
    //    API needed by Customer
    int placeOrder(Order order, Map<Integer, Integer> productIdAndQuantityMap);

    List<Order> fetchCustomerOrders(int customerId);

    //    API needed by Seller
    List<Order> fetchSellerOrders(int sellerId);
}
