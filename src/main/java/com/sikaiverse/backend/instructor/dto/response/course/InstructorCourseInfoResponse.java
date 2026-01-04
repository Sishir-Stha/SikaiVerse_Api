package com.sikaiverse.backend.instructor.dto.response.course;

import lombok.Data;

import java.util.List;

@Data
public class InstructorCourseInfoResponse {

    private String success;
    private List<InstructorCourseInfoData> data;

    public InstructorCourseInfoResponse(String success, List<InstructorCourseInfoData> data){
        this.success = success;
        this.data = data;
    }

}
