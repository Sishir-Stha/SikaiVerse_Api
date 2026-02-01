package com.sikaiverse.backend.student.dto.response.course;

import lombok.Data;

@Data
public class LearnLessonResponse {

    private String success;

    public LearnLessonResponse(String success){
        this.success = success;
    }

}
