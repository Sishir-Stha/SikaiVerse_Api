package com.sikaiverse.backend.landing.dto.response;

import com.sikaiverse.backend.student.dto.response.course.StudentEnrolledModuleData;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CourseDetailData {

    private Integer courseId;
    private String courseTitle;
    private String description;
    private String level;
    private String category;
    private String instructorName;

    private Integer totalModules;
    private Integer totalLessons;
    private BigDecimal totalDuration;

    private BigDecimal rating;
    private Integer totalStudents;
    private String image;

    private List<StudentEnrolledModuleData> modules;
}
