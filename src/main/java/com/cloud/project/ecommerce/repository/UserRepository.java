package com.cloud.project.ecommerce.repository;

import com.cloud.project.ecommerce.model.User;

public interface UserRepository {
    int register(User user);
    int login(Long userId);
}
