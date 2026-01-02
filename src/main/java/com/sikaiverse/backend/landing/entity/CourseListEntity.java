package com.sikaiverse.backend.landing.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class CourseListEntity {

    @Id
    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "instructor")
    private String instructor;

    @Column(name = "category")
    private String category;

    @Column(name = "level")
    private String level;

    @Column(name = "duration")
    private int duration;

    @Column(name = "total_students")
    private int totalStudents;

    @Column(name = "rating")
    private int rating;

    @Column(name = "image")
    private String image;

}
