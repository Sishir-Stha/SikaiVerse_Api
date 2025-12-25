package com.sikaiverse.backend.instructor.dto.response.dashboard;

import lombok.Data;

@Data
public class InstructorDashboardData {

    private int totalCourse;
    private int totalStudents;
    private int totalModule;
    private int totalLesson;
}
