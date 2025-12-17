package com.sikaiverse.backend.instructor.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class InstructorIdRequest {

    @NotBlank(message = " User Id is required ")
    private int userId;
}
