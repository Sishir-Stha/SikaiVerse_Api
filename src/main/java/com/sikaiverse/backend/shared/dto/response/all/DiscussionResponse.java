package com.sikaiverse.backend.shared.dto.response.all;

import lombok.Data;

import java.util.List;

@Data
public class DiscussionResponse {
    private String success;
    private List<DiscussionDto> data;
    public DiscussionResponse(String success,List<DiscussionDto> data){
        this.success = success;
        this.data = data;
    }
}
