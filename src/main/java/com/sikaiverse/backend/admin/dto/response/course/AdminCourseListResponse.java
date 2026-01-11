package com.sikaiverse.backend.admin.dto.response.course;

import lombok.Data;

import java.util.List;

@Data
public class AdminCourseListResponse {

    private String success;
    private List<AdminCourseListData> data;

    public AdminCourseListResponse(String success, List<AdminCourseListData> data){
        this.success = success;
        this.data = data;
    }
}
