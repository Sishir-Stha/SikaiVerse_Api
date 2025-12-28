package com.sikaiverse.backend.shared.dto.request.all;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CourseIdRequest {
    @JsonProperty("courseId")
    @NotBlank(message = " Course Id is required ")
    private int courseId;
}
