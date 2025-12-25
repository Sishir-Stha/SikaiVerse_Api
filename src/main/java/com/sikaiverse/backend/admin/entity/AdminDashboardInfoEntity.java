package com.sikaiverse.backend.admin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class AdminDashboardInfoEntity {

    @Id
    @Column(name = "total_course")
    private int totalCourse;

    @Column(name = "total_student")
    private int totalStudents;

    @Column(name = "total_module")
    private int totalModule;

    @Column(name = "total_lesson")
    private int totalLesson;

}
