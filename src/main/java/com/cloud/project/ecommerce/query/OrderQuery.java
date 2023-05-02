/* SJSU CS 218 Spring 2023 TEAM6 */
package com.cloud.project.ecommerce.query;

public class OrderQuery {
    public static final String CREATE_ORDER =
            "INSERT INTO orders(user_id, order_date, order_status, total_price) VALUES (?, ?, ?, ?)";

    public static final String FETCH_CUSTOMER_ORDERS =
            "SELECT * FROM orders INNER JOIN users USING(user_id) WHERE user_id = ? AND role = 'CUSTOMER'";

    public static final String FETCH_SELLER_ORDERS = "WITH products_cte AS (SELECT u.name as uname, p.* FROM products p INNER JOIN users u ON (p.seller_id = u.user_id) WHERE p.seller_id = ? AND u.role = 'SELLER') " +
            "SELECT * FROM orders INNER JOIN (SELECT * FROM order_product_m2m INNER JOIN products_cte USING (product_id)) t1 USING (order_id)";
}
