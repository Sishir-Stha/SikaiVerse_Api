package com.sikaiverse.backend.student.dto.response.dashboard;

import lombok.Data;


@Data
public class StudentDashboardInfoResponse {
    private String success;
    private StudentDashboardInfoData data;
    public StudentDashboardInfoResponse(String success, StudentDashboardInfoData data){
        this.success = success;
        this.data = data;
    }
}
