package com.sikaiverse.backend.student.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class StudentDashboardInfoEntity {


    @Column(name = "total_courses")
    private int totalCourse;

    @Column(name = "completed")
    private int completed;

    @Column(name = "in_progress")
    private int inProgress;

    @Column(name = "study_time")
    private int studyTime;
    @Id
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "course_title")
    private String courseTitle;

    @Column(name = "description")
    private String courseDescription;

    @Column(name = "progress_percentage")
    private double progressPercentage;

    @Column(name = "total_modules")
    private int totalModules;

}
