package com.sikaiverse.backend.authentication.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private int status;
    private String token;
    private String username;
    private String role;
}
