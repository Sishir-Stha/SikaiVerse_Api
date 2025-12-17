package com.sikaiverse.backend.authentication.dto.response;

import lombok.Data;


@Data
public class LoginDataResponse {
    private String token;
    private String username;
    private String role;
}
