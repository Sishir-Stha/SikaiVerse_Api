package com.sikaiverse.backend.student.entity.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class LessonEntity {

    @Id
    @Column(name = "lesson_title")
    private String lessonTitle;

    @Column(name = "description")
    private String description;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "status")
    private String status;

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "lesson_data")
    private String lessonData;

    @Column(name = "lesson_content")
    private String lessonContent;
}
