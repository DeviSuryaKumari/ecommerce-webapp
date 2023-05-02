/* SJSU CS 218 Spring 2023 TEAM6 */
package com.cloud.project.ecommerce.repository;

import com.cloud.project.ecommerce.model.Product;
import com.cloud.project.ecommerce.query.ProductQuery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements  ProductRepository {
    private final JdbcTemplate jdbcTemplate;

    public ProductRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> fetchAllProducts() {
        String sqlQuery = ProductQuery.FETCH_ALL_PRODUCTS;

        return jdbcTemplate.query(sqlQuery, this::mapRowToProduct);
    }

    @Override
    public Product fetchProductDetails(int productId) {
        String sqlQuery = ProductQuery.FETCH_PRODUCT_DETAILS;

        return jdbcTemplate.queryForObject(sqlQuery, this::mapRowToProduct, productId);
    }

    @Override
    public List<Product> fetchProductsByCategory(int categoryId) {
        String sqlQuery = ProductQuery.FETCH_PRODUCTS_BY_CATEGORY;

        return jdbcTemplate.query(sqlQuery, this::mapRowToProduct, categoryId);
    }

    @Override
    public int addProduct(Product product) {
        String sqlQuery = ProductQuery.ADD_PRODUCT;

        return jdbcTemplate.update(sqlQuery,
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantityAvailable(),
                product.getSellerId());
    }

    @Override
    public int deleteProduct(int productId) {
        String sqlQuery = ProductQuery.DELETE_PRODUCT;

        return jdbcTemplate.update(sqlQuery, productId);
    }

    @Override
    public List<Product> fetchSellerProducts(int sellerId) {
        String sqlQuery = ProductQuery.FETCH_SELLER_PRODUCTS;

        return jdbcTemplate.query(sqlQuery, this::mapRowToProduct, sellerId);
    }

    private Product mapRowToProduct(ResultSet resultSet, int rowNum) throws SQLException {

        Product product = new Product();

        product.setProductId(resultSet.getLong("product_id"));
        product.setName(resultSet.getString("name"));
        product.setDescription(resultSet.getString("description"));
        product.setPrice(resultSet.getFloat("price"));
        product.setQuantityAvailable(resultSet.getInt("quantity_available"));
        product.setSellerId(resultSet.getLong("seller_id"));

        return product;
    }
}
