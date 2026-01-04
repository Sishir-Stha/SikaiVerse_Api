package com.sikaiverse.backend.admin.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AdminUpdateUserRequest {
    @NotNull(message = "User Id is required")
    private Long userId;
    private String fullName;
    private String email;
    private String role;
    private String status;
    private String phoneNumber;
    private String address;

}
