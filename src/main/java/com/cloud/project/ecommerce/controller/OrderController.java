/* SJSU CS 218 Spring 2023 TEAM6 */
package com.cloud.project.ecommerce.controller;

import com.cloud.project.ecommerce.model.Order;
import com.cloud.project.ecommerce.model.OrderPostData;
import com.cloud.project.ecommerce.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @CrossOrigin
    @PostMapping("/new")
    public ResponseEntity<?> placeOrder(@RequestBody OrderPostData orderPostData) {
        try {
            int createdOrderId = orderRepository.placeOrder(orderPostData.getOrder(), orderPostData.getProductIdAndQuantityMap());
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createdOrderId)
                    .toUri();
            return ResponseEntity.created(location).body("Order successfully created!");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @CrossOrigin
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Order>> fetchCustomerOrders(@PathVariable int customerId) {
        try {
            List<Order> orders = orderRepository.fetchCustomerOrders(customerId);
            return ResponseEntity.ok(orders);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @CrossOrigin
    @GetMapping("/seller/{sellerId}")
    public ResponseEntity<List<Order>> fetchSellerOrders(@PathVariable int sellerId) {
        try {
            List<Order> orders = orderRepository.fetchSellerOrders(sellerId);
            return ResponseEntity.ok(orders);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
