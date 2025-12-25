package com.sikaiverse.backend.student.dto.response.course;

import lombok.Data;

import java.util.List;


@Data
public class StudentCourseInfoResponse {

    private String success;
    private List<StudentCourseInfoData> data;

    public StudentCourseInfoResponse(String success, List<StudentCourseInfoData> data){
        this.success = success;
        this.data = data;
    }

}
