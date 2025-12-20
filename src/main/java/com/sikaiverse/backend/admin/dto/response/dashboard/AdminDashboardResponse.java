package com.sikaiverse.backend.admin.dto.response.dashboard;

import lombok.Data;

@Data
public class AdminDashboardResponse {
    private String success;
    private AdminDashboardData data;

    public AdminDashboardResponse(String success, AdminDashboardData data){
        this.success = success;
        this.data = data;
    }
}
