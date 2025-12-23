package com.sikaiverse.backend.shared.entity.privileged;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class EditCourseInfoEntity {
    // ---------Course-------


    @Column(name = "course_id")
    private Integer courseId;

    @Column(name = "course_title")
    private String courseTitle;

    @Column(name = "description")
    private String description;

    @Column(name = "instructor_name")
    private String instructorName;

    @Column(name = "category")
    private String category;

    @Column(name = "level")
    private String level;


    // ---------Modules -------
    @Column(name = "module_id")
    private Integer moduleId;

    @Column(name = "module_title")
    private String moduleTitle;

    @Column(name = "no_of_lessons")
    private Integer noOfLessons;


    // ---------Lesson -------
    @Id
    @Column(name = "lesson_id")
    private Integer lessonId;

    @Column(name = "lesson_title")
    private String lessonTitle;

    @Column(name = "duration")
    private Integer duration;



}
