package com.sikaiverse.backend.instructor.dto.response.course;

import lombok.Data;

@Data
public class InstructorCourseListResponse {

    private String success;
    private InstructorCourseListData data;

    public InstructorCourseListResponse(String success,InstructorCourseListData data){
        this.success = success;
        this.data = data;
    }
}
