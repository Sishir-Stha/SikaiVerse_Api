package com.sikaiverse.backend.student.dto.response.course;

import lombok.Data;

@Data
public class EnrolledLessonResponse {

    private String success;
    private EnrolledLessonData data;

    public EnrolledLessonResponse (String success,EnrolledLessonData data){
        this.success = success;
        this.data = data;
    }
}
