package com.sikaiverse.backend.shared.dto.request.all;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserIdRequest {

    @NotBlank(message = " User Id is required ")
    private int userId;

}

