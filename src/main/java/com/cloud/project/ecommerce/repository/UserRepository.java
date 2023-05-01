package com.cloud.project.ecommerce.repository;

import com.cloud.project.ecommerce.model.User;

public interface UserRepository {
    User fetchUser(int userId);
    int register(User user);
    int login(Integer userId);
    int logout(Integer userId);
}
