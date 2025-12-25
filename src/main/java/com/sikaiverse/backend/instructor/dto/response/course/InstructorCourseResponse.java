package com.sikaiverse.backend.instructor.dto.response.course;

import lombok.Data;

import java.util.List;

@Data
public class InstructorCourseResponse {

    private String success;
    private List<InstructorCourseInfoData> data;

    public InstructorCourseResponse(String success, List<InstructorCourseInfoData> data){
        this.success = success;
        this.data = data;
    }

}
