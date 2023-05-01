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

    @CrossOrigin
    @GetMapping("/")
    public ResponseEntity<List<Product>> fetchAllProducts() {
        try {
            List<Product> products = productRepository.fetchAllProducts();
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @CrossOrigin
    @GetMapping("/{productId}")
    public ResponseEntity<Product> fetchProductDetails(@PathVariable int productId) {
        try {
            Product product = productRepository.fetchProductDetails(productId);
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @CrossOrigin
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> fetchProductsByCategory(@PathVariable int categoryId) {
        try {
            List<Product> products = productRepository.fetchProductsByCategory(categoryId);
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @CrossOrigin
    @PostMapping("/")
    public ResponseEntity<Product> addProduct(@RequestBody Product product)  {
        int rowsAffected = productRepository.addProduct(product);
        return (rowsAffected > 0) ? ResponseEntity.ok(product)
                : ResponseEntity.internalServerError().build();
    }

    @CrossOrigin
    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable int productId) {
        int rowsAffected = productRepository.deleteProduct(productId);
        return (rowsAffected > 0) ? ResponseEntity.ok("deleted")
                : ResponseEntity.internalServerError().build();
    }

    @CrossOrigin
    @GetMapping("/seller/{sellerId}")
    public ResponseEntity<List<Product>> fetchSellerProducts(@PathVariable int sellerId) {
        try {
            List<Product> products = productRepository.fetchSellerProducts(sellerId);
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
