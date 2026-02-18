package com.sikaiverse.backend.shared.dto.response.privileged;

import lombok.Data;

import java.util.List;

@Data
public class InstructorListResponse {
    private String success;
    private List<InstructorListData> data;

    public InstructorListResponse (String success , List<InstructorListData> data){
        this.success = success;
        this.data = data;
    }
}
