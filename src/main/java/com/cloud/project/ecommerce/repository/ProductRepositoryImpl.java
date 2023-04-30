package com.cloud.project.ecommerce.repository;

import com.cloud.project.ecommerce.CONSTANTS;
import com.cloud.project.ecommerce.model.Order;
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
    public List<Product> fetchProductsByCategory(int categoryId) {
        String sqlQuery = ProductQuery.FETCH_PRODUCTS_BY_CATEGORY;

        return jdbcTemplate.query(sqlQuery, this::mapRowToProduct, categoryId);
    }

    @Override
    public Product fetchProductDetails(int productId) {
        String sqlQuery = ProductQuery.FETCH_PRODUCT_DETAILS;

        return jdbcTemplate.queryForObject(sqlQuery, this::mapRowToProduct, productId);
    }

    @Override
    public List<Product> fetchAllProducts() {
        String sqlQuery = ProductQuery.FETCH_ALL_PRODUCTS;

        return jdbcTemplate.query(sqlQuery, this::mapRowToProduct);
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
    public List<Product> fetchMyProducts(int sellerId) {
        String sqlQuery = ProductQuery.FETCH_MY_PRODUCTS;

        return jdbcTemplate.query(sqlQuery, this::mapRowToProduct, sellerId);
    }

    @Override
    public List<Order> fetchMyOrders(int sellerId) {
        String sqlQuery = ProductQuery.FETCH_MY_ORDERS;

        return jdbcTemplate.query(sqlQuery, this::mapRowToOrder, sellerId);
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

    private Order mapRowToOrder(ResultSet resultSet, int rowNum) throws SQLException {

        Order order = new Order();

        order.setOrderId(resultSet.getLong("order_id"));
        order.setUserId(resultSet.getLong("user_id"));
        order.setOrderDate(resultSet.getDate("order_date").toString());
        order.setOrderStatus(CONSTANTS.ORDER_STATUS.valueOf(resultSet.getString("order_status")));
        order.setTotalPrice(resultSet.getDouble("total_price"));

        return order;
    }
}
