package com.sikaiverse.backend.student.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CourseEnrollmentRequest {

    @NotBlank(message = " User Id is required ")
    private int userId;

    @NotBlank(message = " Course Id is required ")
    private int courseId;

}
