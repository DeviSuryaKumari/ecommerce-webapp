package com.cloud.project.ecommerce.repository;

import com.cloud.project.ecommerce.model.Order;
import com.cloud.project.ecommerce.model.Product;

import java.util.List;

public interface ProductRepository {
    //   API needed for Customer
    public List<Product> fetchProductsByCategory(int categoryId);
    public Product fetchProductDetails(int productId);
    public List<Product> fetchAllProducts();

    //   API needed for Seller
    public int addProduct(Product product);
    public int deleteProduct(int productId);
    public List<Product> fetchMyProducts(int sellerId);
    public List<Order> fetchMyOrders(int sellerId);
}
