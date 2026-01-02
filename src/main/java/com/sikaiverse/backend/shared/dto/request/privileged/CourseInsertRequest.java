package com.sikaiverse.backend.shared.dto.request.privileged;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CourseInsertRequest {

    @NotBlank(message = " Title is required ")
    private String title;
    @NotBlank(message = " Description is required ")
    private String description;
    @NotBlank(message = " Instructor id is required ")
    private Integer instructorId;
    @NotBlank(message = " Category is required ")
    private String category;
    @NotBlank(message = " Level is required ")
    private String level;
    @NotBlank(message = " Duration is required ")
    private Integer duration;
    @NotBlank(message = " Image is required ")
    private String image;
    @NotBlank(message = " Rating is required ")
    private Double rating;
    @NotBlank(message = " Total Students is required ")
    private Integer totalStudents;
}
