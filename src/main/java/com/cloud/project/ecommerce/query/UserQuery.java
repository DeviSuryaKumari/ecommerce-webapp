package com.cloud.project.ecommerce.query;

public class UserQuery {
    public static final String REGISTER =
            "INSERT INTO users(name, username, password, email, role, is_logged_in) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";

    public static final String LOGIN = "UPDATE users SET is_logged_in = 1 WHERE user_id = ?";
}
