package com.sikaiverse.backend.student.dto.response.dashboard;

import lombok.Data;

import java.util.List;

@Data
public class StudentDashboardInfoData {
    private int totalCourse;
    private int completed;
    private int inProgress;
    private int studyTime;
    private List<StudentDashboardCourseData> courseData;
}
