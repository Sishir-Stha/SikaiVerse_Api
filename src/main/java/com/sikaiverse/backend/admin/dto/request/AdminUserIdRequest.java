package com.sikaiverse.backend.admin.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AdminUserIdRequest {

    @NotBlank(message = " User Id is required ")
    private int userId;
}
