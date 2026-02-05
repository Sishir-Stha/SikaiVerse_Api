package com.sikaiverse.backend.landing.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LandingCourseIdRequest {

    @NotBlank(message = " Course Id is required ")
    private int courseId;
}
