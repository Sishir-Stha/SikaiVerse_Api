package com.sikaiverse.backend.shared.dto.request.privileged;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PrivilegedCourseId {
    @NotBlank(message = " Course Id is required ")
    private int courseId;
}
