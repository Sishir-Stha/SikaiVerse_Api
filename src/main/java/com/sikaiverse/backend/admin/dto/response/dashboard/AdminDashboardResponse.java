package com.sikaiverse.backend.admin.dto.response.dashboard;

import com.sikaiverse.backend.admin.dto.response.course.AdminCourseData;
import lombok.Data;

import java.util.List;

@Data
public class AdminDashboardResponse {
    private String success;
    private AdminDashboardData data;

    public AdminDashboardResponse(String success, AdminDashboardData data){
        this.success = success;
        this.data = data;
    }
}
