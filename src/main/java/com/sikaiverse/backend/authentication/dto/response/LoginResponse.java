package com.sikaiverse.backend.authentication.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    private String success;
    private LoginDataResponse data;
}
