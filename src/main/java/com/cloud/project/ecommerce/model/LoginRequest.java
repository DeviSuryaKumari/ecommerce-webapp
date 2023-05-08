/* SJSU CS 218 Spring 2023 TEAM6 */
package com.cloud.project.ecommerce.model;

import com.cloud.project.ecommerce.CONSTANTS;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginRequest {
    String username;
    String password;
    CONSTANTS.ROLE role;
}
