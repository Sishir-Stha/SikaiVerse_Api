package com.sikaiverse.backend.student.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LessonIdRequest {

    @NotBlank(message = " Lesson Id is required ")
    private int lessonId;

}
