package com.cloud.project.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginRequest {
    int userId;
    String username;
    String password;
}
