package com.cloud.project.ecommerce.query;

public class UserQuery {
    public static final String REGISTER =
            "INSERT INTO users(id, name, username, password, email, role, is_logged_in) " +
                    "VALUES (null, ?, ?, ?, ?, ?, false)";

    public static final String LOGIN = "UPDATE users SET is_logged_in = true WHERE id = ?";
}
