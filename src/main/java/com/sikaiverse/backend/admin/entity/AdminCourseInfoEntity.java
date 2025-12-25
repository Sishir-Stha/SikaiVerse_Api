package com.sikaiverse.backend.admin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class AdminCourseInfoEntity {

    @Id
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "course_title")
    private String courseTitle;

    @Column(name = "description")
    private String description;

    @Column(name = "level")
    private String level;

    @Column(name = "instructor_name")
    private String instructorName;

    @Column(name = "total_modules")
    private int totalModule;

    @Column(name = "total_lessons")
    private int totalLesson;

    @Column(name = "total_duration")
    private int totalDuration;

    @Column(name = "rating")
    private double rating;

}
