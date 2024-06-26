/* SJSU CS 218 Spring 2023 TEAM6 */
package com.cloud.project.ecommerce.query;

public class UserQuery {
    public static final String FETCH_USER = "SELECT * FROM users WHERE user_id = ?";

    public static final String FETCH_USER_BY_USERNAME = "SELECT * FROM users WHERE username = ?";
    public static final String REGISTER =
            "INSERT INTO users(name, username, password, email, role, is_logged_in) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

    public static final String LOGIN = "UPDATE users SET is_logged_in = 1 WHERE user_id = ?";

    public static final String LOGOUT = "UPDATE users SET is_logged_in = 0 WHERE user_id = ?";
}
