package com.sikaiverse.backend.student.dto.response.course;

import lombok.Data;

@Data
public class IsEnrolledResponse {

    private String success;

    public IsEnrolledResponse(String success){
        this.success = success;
    }

}
