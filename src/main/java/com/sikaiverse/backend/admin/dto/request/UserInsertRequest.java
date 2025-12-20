package com.sikaiverse.backend.admin.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserInsertRequest {

    @NotBlank(message = "User Id is required")
    private int userId;
    @NotBlank(message = "Full Name is required")
    private String fullName;
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "Role is required")
    private String role;
    @NotBlank(message = "Status is required")
    private String status;
}
