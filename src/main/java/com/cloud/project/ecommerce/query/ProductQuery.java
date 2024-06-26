/* SJSU CS 218 Spring 2023 TEAM6 */
package com.cloud.project.ecommerce.query;

public class ProductQuery {
    //    Customer API Queries
    public static final String FETCH_ALL_PRODUCTS = "SELECT * FROM products";

    public static final String FETCH_PRODUCT_DETAILS = "SELECT * FROM products WHERE product_id = ?";

    public static final String FETCH_PRODUCTS_BY_CATEGORY = "SELECT products.* " +
            "FROM products INNER JOIN product_category_m2m USING(product_id)" +
            "WHERE category_id = ?";

    //    Seller API Queries
    public static final String ADD_PRODUCT = "INSERT INTO products (name, description, price, quantity_available," +
            "seller_id) VALUES (?, ?, ?, ?, ?)";

    public static final String DELETE_PRODUCT = "DELETE FROM products WHERE product_id = ?";

    public static final String FETCH_SELLER_PRODUCTS = "SELECT * FROM products WHERE seller_id = ?";
}
