package com.sikaiverse.backend.shared.dto.request.all;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CourseIdRequest {
    @JsonProperty("courseId")
    private int courseId;
}
