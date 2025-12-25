package com.sikaiverse.backend.landing.dto.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class CourseListRequest {

    @NotBlank(message = "Course Id is required")
    private int courseId;

    @NotBlank(message = "Level is required")
    private String level;

    @NotBlank(message = "Category is required")
    private String category;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Rating is required")
    private double rating;

}
