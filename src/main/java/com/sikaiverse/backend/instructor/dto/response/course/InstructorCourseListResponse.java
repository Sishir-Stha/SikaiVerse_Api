package com.sikaiverse.backend.instructor.dto.response.course;

import lombok.Data;

import java.util.List;

@Data
public class InstructorCourseListResponse {

    private String success;
    private List<InstructorCourseListData> data;

    public InstructorCourseListResponse(String success, List<InstructorCourseListData> data){
        this.success = success;
        this.data = data;
    }
}
