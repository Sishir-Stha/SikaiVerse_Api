package com.sikaiverse.backend.course.dto.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CourseInsertRequest {

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotNull(message = "Instructor ID is required")
    @Positive(message = "Instructor ID must be a positive number")
    private Integer instructorId;

    @NotBlank(message = "Category cannot be blank")
    private String category;

    @NotBlank(message = "Level cannot be blank")
    private String level;

    @NotNull(message = "Duration is required")
    @Min(value = 1, message = "Duration must be at least 1 minute")
    private Integer duration;

    @NotBlank(message = "Image URL cannot be blank")
    private String image;

    // Rating (optional) — numeric and nullable
    @DecimalMin(value = "0.0", inclusive = true, message = "Rating cannot be negative")
    @DecimalMax(value = "5.0", inclusive = true, message = "Rating cannot exceed 5.0")
    private Double rating;

    @NotNull(message = "Total students count is required")
    @Min(value = 0, message = "Total students cannot be negative")
    private Integer totalStudents;

}
