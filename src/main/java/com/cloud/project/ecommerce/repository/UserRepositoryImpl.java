/* SJSU CS 218 Spring 2023 TEAM6 */
package com.cloud.project.ecommerce.repository;

import com.cloud.project.ecommerce.CONSTANTS;
import com.cloud.project.ecommerce.model.User;
import com.cloud.project.ecommerce.query.UserQuery;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User fetchUser(int userId) {
        String sqlQuery = UserQuery.FETCH_USER;

        return jdbcTemplate.queryForObject(sqlQuery, this::mapRowToUser, userId);
    }

    @Override
    public int register(User user) {

        String sqlQuery = UserQuery.REGISTER;

        return jdbcTemplate.update(sqlQuery,
                user.getName(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getRole().name(),
                user.getIsLoggedIn());
    }

    @Override
    public int login(Integer userId) {

        String sqlQuery = UserQuery.LOGIN;

        return jdbcTemplate.update(sqlQuery, userId);
    }

    @Override
    public int logout(Integer userId) {

        String sqlQuery = UserQuery.LOGOUT;

        return jdbcTemplate.update(sqlQuery, userId);
    }

    private User mapRowToUser(ResultSet resultSet, int rowNum) throws SQLException {
        User user =  new User();

        user.setUserId(resultSet.getInt("user_id"));
        user.setName(resultSet.getString("name"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        user.setEmail(resultSet.getString("email"));
        user.setRole(CONSTANTS.ROLE.valueOf(resultSet.getString("role")));
        user.setIsLoggedIn(resultSet.getBoolean("is_logged_in"));

        return user;
    }
}
