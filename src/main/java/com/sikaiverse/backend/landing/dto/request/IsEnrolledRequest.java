package com.sikaiverse.backend.landing.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class IsEnrolledRequest {

    @NotBlank(message = " User Id is required ")
    private int userId;

    @NotBlank(message = " Course Id is required ")
    private int courseId;

}
