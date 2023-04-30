package com.cloud.project.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
    private Long userId;
    private String name;
    private String username;
    private String password;
    private String email;
    private Enum role;
    private Boolean isLoggedIn;
}
