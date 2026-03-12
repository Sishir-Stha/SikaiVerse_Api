package com.sikaiverse.backend.student.dto.response.course;


import lombok.Data;

@Data

public class StudentEnrolledResponse {
    private String success;
    private StudentEnrolledCourseData data;

    public StudentEnrolledResponse(String success,StudentEnrolledCourseData data){
        this.success = success;
        this.data = data;
    }
}
