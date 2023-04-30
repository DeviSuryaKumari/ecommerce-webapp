package com.cloud.project.ecommerce.repository;

import com.cloud.project.ecommerce.model.User;

public interface UserRepository {
    public int register(User user);
    public int login(Long userId);
}
