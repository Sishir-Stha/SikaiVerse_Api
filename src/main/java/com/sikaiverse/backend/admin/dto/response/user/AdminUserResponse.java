package com.sikaiverse.backend.admin.dto.response.user;

import lombok.Data;

import java.util.List;

@Data
public class AdminUserResponse {
    private String success;
    private List<AdminUserData> data;

    public AdminUserResponse(String success, List<AdminUserData> data){
        this.success = success;
        this.data = data;
    }
}
