package com.sikaiverse.backend.student.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CourseIdRequest {

    @NotBlank(message = " Course Id is required ")
    private int courseId;
}
