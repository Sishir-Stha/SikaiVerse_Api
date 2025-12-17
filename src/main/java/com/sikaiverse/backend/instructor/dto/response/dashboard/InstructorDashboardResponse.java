package com.sikaiverse.backend.instructor.dto.response.dashboard;

import lombok.Data;

@Data
public class InstructorDashboardResponse {

    private String success;
    private InstructorDashboardData data;

    public InstructorDashboardResponse(String success,InstructorDashboardData data){
        this.success = success;
        this.data = data;
    }

}
