package com.cloud.project.ecommerce.repository;

import com.cloud.project.ecommerce.CONSTANTS;
import com.cloud.project.ecommerce.model.Order;
import com.cloud.project.ecommerce.query.OrderQuery;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private final JdbcTemplate jdbcTemplate;

    public OrderRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int placeOrder(Order order, Map<Integer, Integer> productIdAndQuantityMap) {
        jdbcTemplate.execute("START TRANSACTION;");

        int affectedRowCount = jdbcTemplate.update(OrderQuery.CREATE_ORDER, order.getUserId(), order.getOrderDate(),
                order.getOrderStatus().name(), order.getTotalPrice());


        if (affectedRowCount > 0) {
           int insertedOrderId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);

            List<Integer> productIds = new ArrayList<>(productIdAndQuantityMap.keySet());

            jdbcTemplate.batchUpdate(
                    "INSERT INTO order_product_m2m (order_id, product_id, quantity) VALUES (?, ?, ?)",
                    new BatchPreparedStatementSetter() {
                        @Override
                        public void setValues(PreparedStatement ps, int i) throws SQLException {
                            ps.setInt(1, insertedOrderId);
                            ps.setInt(2, productIds.get(i));
                            ps.setInt(3, productIdAndQuantityMap.get(productIds.get(i)));
                        }
                        @Override
                        public int getBatchSize() {
                            return productIds.size();
                        }
                    });
            jdbcTemplate.execute("COMMIT;");
            return insertedOrderId;
        } else {
            jdbcTemplate.execute("ROLLBACK;");
            return -1;
        }
    }

    @Override
    public List<Order> fetchCustomerOrders(int customerId) {
        String sqlQuery = OrderQuery.FETCH_CUSTOMER_ORDERS;

        return jdbcTemplate.query(sqlQuery, this::mapRowToOrder, customerId);
    }

//    @Override
//    public List<Order> fetchSellerOrders(int sellerId) {
//        String sqlQuery = OrderQuery.FETCH_SELLER_ORDERS;
//
//        return jdbcTemplate.query(sqlQuery, this::mapRowToOrder, sellerId);
//    }

    private Order mapRowToOrder(ResultSet resultSet, int rowNum) throws SQLException {

        Order order = new Order();

        order.setOrderId(resultSet.getInt("order_id"));
        order.setUserId(resultSet.getInt("user_id"));
        order.setOrderDate(resultSet.getDate("order_date").toString());
        order.setOrderStatus(CONSTANTS.ORDER_STATUS.valueOf(resultSet.getString("order_status")));
        order.setTotalPrice(resultSet.getDouble("total_price"));

        return order;
    }
}
