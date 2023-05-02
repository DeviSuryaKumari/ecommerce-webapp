/* SJSU CS 218 Spring 2023 TEAM6 */
package com.cloud.project.ecommerce.model;

import com.cloud.project.ecommerce.CONSTANTS;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {

    private Integer userId;
    private String name;
    private String username;
    private String password;
    private String email;
    private CONSTANTS.ROLE role;
    private Boolean isLoggedIn;
}
