package com.sikaiverse.backend.student.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class DashboardInfoData {
    private int totalCourse;
    private int completed;
    private int inProgress;
    private int studyTime;
    private List<DashboardCourseData> courseData;
}
