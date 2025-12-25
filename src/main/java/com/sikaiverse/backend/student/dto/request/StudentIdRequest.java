package com.sikaiverse.backend.student.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StudentIdRequest {

    @NotBlank(message = " User Id is required ")
    private int userId;
}
