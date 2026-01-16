package com.sikaiverse.backend.student.dto.response.course;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data

public class StudentEnrolledResponse {
    private String success;
    private StudentEnrolledCourseData data;

    public StudentEnrolledResponse(String success,StudentEnrolledCourseData data){
        this.success = success;
        this.data = data;
    }
}
