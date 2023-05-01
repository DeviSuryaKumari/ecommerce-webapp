package com.cloud.project.ecommerce.query;

public class OrderQuery {
    public static final String CREATE_ORDER =
            "INSERT INTO orders(user_id, order_date, order_status, total_price) VALUES (?, ?, ?, ?)";

    public static final String FETCH_CUSTOMER_ORDERS =
            "SELECT * FROM orders INNER JOIN users USING(user_id) WHERE user_id = ? AND role = 'CUSTOMER'";

//    public static final String FETCH_SELLER_ORDERS = "SELECT * FROM orders " +
//            "INNER JOIN (SELECT order_id " +
//            "FROM order_product_m2m INNER JOIN " +
//            "(SELECT * FROM products INNER JOIN " +
//            "users ON(products.seller_id = users.user_id) WHERE seller_id = ?) USING(product_id)) AS order_ids USING(order_id)";
}
