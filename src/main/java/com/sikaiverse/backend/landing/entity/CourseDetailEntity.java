package com.sikaiverse.backend.landing.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class CourseDetailEntity {

    @Id
    @Column(name = "course_id")
    private Integer courseId;
    @Column(name = "course_title")
    private String courseTitle;
    @Column(name = "description")
    private String description;
    @Column(name = "level")
    private String level;
    @Column(name = "category")
    private String category;

    @Column(name = "instructor_name")
    private String instructorName;
    @Column(name = "total_modules")
    private Integer totalModules;
    @Column(name = "total_lessons")
    private Integer totalLessons;
    @Column(name = "total_duration")
    private BigDecimal totalDuration;
    @Column(name = "rating")
    private BigDecimal rating;
    @Column(name = "total_students")
    private Integer totalStudents;
    @Column(name = "image")
    private String image;

    @Column(name = "modules")
    private String modules;
}
