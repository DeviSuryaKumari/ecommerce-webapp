package com.cloud.project.ecommerce.controller;

import com.cloud.project.ecommerce.model.Product;
import com.cloud.project.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public ResponseEntity<List<Product>> fetchAllProducts() {
        try {
            List<Product> products = productRepository.fetchAllProducts();
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> fetchProductDetails(@PathVariable int productId) {
        try {
            Product product = productRepository.fetchProductDetails(productId);
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> fetchProductsByCategory(@PathVariable int categoryId) {
        try {
            List<Product> products = productRepository.fetchProductsByCategory(categoryId);
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Product> addProduct(@RequestBody Product product)  {
        int rowsAffected = productRepository.addProduct(product);
        return (rowsAffected > 0) ? ResponseEntity.ok(product)
                : ResponseEntity.internalServerError().build();
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable int productId) {
        int rowsAffected = productRepository.deleteProduct(productId);
        return (rowsAffected > 0) ? ResponseEntity.ok("deleted")
                : ResponseEntity.internalServerError().build();
    }

    @GetMapping("/seller/{sellerId}")
    public ResponseEntity<List<Product>> fetchSellerProducts(@PathVariable int sellerId) {
        try {
            List<Product> products = productRepository.fetchSellerProducts(sellerId);
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

//    @GetMapping("/seller/{id}")
//    public ResponseEntity<List<Product>> fetchSellerOrders(@PathVariable int sellerId) {
//        try {
//            List<Order> orders = orderRepository.fetchSellerOrders(sellerId);
//            return ResponseEntity.ok(orders);
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().build();
//        }
//    }
}
