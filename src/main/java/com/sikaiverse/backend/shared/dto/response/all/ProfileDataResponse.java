package com.sikaiverse.backend.shared.dto.response.all;

import lombok.Data;

@Data
public class ProfileDataResponse {
    private String success;
    private ProfileData data;

    public ProfileDataResponse(String success, ProfileData data){
        this.success = success;
        this.data = data;
    }
}
