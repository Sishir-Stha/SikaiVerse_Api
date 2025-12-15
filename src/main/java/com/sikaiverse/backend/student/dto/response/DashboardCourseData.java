package com.sikaiverse.backend.student.dto.response;

import lombok.Data;

@Data
public class DashboardCourseData {
    private int courseId;
    private String courseTitle;
    private String courseDescription;
    private double progressPercentage;
    private int totalModules;
}
