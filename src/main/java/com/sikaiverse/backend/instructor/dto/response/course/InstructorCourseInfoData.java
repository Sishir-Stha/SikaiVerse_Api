package com.sikaiverse.backend.instructor.dto.response.course;

import lombok.Data;

@Data
public class InstructorCourseInfoData {
    private int courseId;
    private String courseTitle;
    private String description;
    private String level;
    private String instructorName;
    private int totalModules;
    private int totalLessons;
    private int totalDuration;
    private double rating;
}
