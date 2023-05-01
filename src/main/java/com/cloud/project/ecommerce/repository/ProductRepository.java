package com.cloud.project.ecommerce.repository;

import com.cloud.project.ecommerce.model.Product;

import java.util.List;

public interface ProductRepository {
    //   API needed for Customer
    List<Product> fetchAllProducts();
    Product fetchProductDetails(int productId);
    List<Product> fetchProductsByCategory(int categoryId);

    //   API needed for Seller
    int addProduct(Product product);
    int deleteProduct(int productId);
    List<Product> fetchSellerProducts(int sellerId);
}
