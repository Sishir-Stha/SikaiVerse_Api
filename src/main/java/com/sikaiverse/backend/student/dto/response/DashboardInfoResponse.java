package com.sikaiverse.backend.student.dto.response;

import lombok.Data;


@Data
public class DashboardInfoResponse {
    private String success;
    private DashboardInfoData data;
    public DashboardInfoResponse(String success,DashboardInfoData data){
        this.success = success;
        this.data = data;
    }
}
