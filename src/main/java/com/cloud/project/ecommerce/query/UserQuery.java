package com.cloud.project.ecommerce.query;

public class UserQuery {
    public static final String SAVE =
            "insert into users(first_name, "
                    + "last_name, email) "
                    + "values (?, ?, ?)";

    public static final String UPDATE =
            "update users set "
                    + "first_name = ?, last_name = ?,"
                    + " email = ? " + "where id = ?";
}
