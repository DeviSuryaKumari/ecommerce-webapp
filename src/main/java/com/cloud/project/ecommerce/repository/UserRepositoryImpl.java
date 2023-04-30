package com.cloud.project.ecommerce.repository;

import com.cloud.project.ecommerce.model.User;
import com.cloud.project.ecommerce.query.UserQuery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int register(User user) {

        String sqlQuery = UserQuery.SAVE;

        return jdbcTemplate.update(sqlQuery,
                null,
                user.getName(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getRole(),
                user.getIsLoggedIn());
    }

    @Override
    public int signIn(Long userId) {

        String sqlQuery = UserQuery.UPDATE;

        return jdbcTemplate.update(sqlQuery, userId);
    }
}
