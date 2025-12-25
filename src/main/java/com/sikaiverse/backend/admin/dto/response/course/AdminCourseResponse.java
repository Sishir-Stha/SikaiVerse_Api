package com.sikaiverse.backend.admin.dto.response.course;

import lombok.Data;

import java.util.List;

@Data
public class AdminCourseResponse {
    private String success;
    private List<AdminCourseData> data;

    public AdminCourseResponse(String success, List<AdminCourseData> data){
        this.success = success;
        this.data = data;
    }
}
