package com.sikaiverse.backend.landing.dto.response;

import lombok.Data;

@Data
public class CourseDataResponse {
    private Long courseId;
    private String title;
    private String description;
    private String instructor;
    private String level;
    private String category;
    private int duration;
    private int totalStudents;
    private int rating;
    private String image;

}
