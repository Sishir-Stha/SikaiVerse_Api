package com.sikaiverse.backend.instructor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class InstructorCourseListEntity {

    @Id
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "course_title")
    private String courseTitle;
}
