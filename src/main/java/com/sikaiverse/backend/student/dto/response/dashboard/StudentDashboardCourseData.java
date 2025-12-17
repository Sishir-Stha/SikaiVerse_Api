package com.sikaiverse.backend.student.dto.response.dashboard;

import lombok.Data;

@Data
public class StudentDashboardCourseData {
    private int courseId;
    private String courseTitle;
    private String courseDescription;
    private double progressPercentage;
    private int totalModules;
}
