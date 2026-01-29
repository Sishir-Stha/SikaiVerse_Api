package com.sikaiverse.backend.student.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class IsEnrolledRequest {
    @NotBlank(message = " Lesson Id is required ")
    private int lessonId;

    @NotBlank(message = " User Id is required ")
    private int userId;
}
