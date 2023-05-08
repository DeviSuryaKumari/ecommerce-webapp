/* SJSU CS 218 Spring 2023 TEAM6 */
package com.cloud.project.ecommerce.repository;

import com.cloud.project.ecommerce.model.User;

public interface UserRepository {
    User fetchUser(String username);
    int register(User user);
    int login(String username, String password);
    int logout(String username);
}
