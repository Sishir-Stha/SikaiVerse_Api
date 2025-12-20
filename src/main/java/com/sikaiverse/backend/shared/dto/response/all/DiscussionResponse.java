package com.sikaiverse.backend.shared.dto.response.all;

import lombok.Data;

@Data
public class DiscussionResponse {
    private String success;
    private DiscussionDto data;
    public DiscussionResponse(String success,DiscussionDto data){
        this.success = success;
        this.data = data;
    }
}
