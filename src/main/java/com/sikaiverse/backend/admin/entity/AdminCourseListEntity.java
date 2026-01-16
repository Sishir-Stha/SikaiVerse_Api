package com.sikaiverse.backend.admin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class AdminCourseListEntity {

    @Id
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "course_title")
    private String courseTitle;

    @Column(name = "no_of_lesson")
    private int noOfLessons;
}
