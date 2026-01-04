package com.sikaiverse.backend.instructor.dto.response.course;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class InstructorCourseListData {

    private int courseId;
    private String courseTitle;
}
