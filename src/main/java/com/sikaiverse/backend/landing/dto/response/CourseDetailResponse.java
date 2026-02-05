package com.sikaiverse.backend.landing.dto.response;

import lombok.Data;

@Data
public class CourseDetailResponse {
    private String success;
    private CourseDetailData data;

    public CourseDetailResponse(String success,CourseDetailData data){
        this.success = success;
        this.data = data;
    }
}
