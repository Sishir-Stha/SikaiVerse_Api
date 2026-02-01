package com.sikaiverse.backend.student.dto.response.course;

import lombok.Data;

@Data
public class EnrolledLessonData {
    private String lessonTitle;
    private String description;
    private Integer duration;
    private String status;
    private String contentType;
    private String lessonData;
    private String lessonContent;
}
