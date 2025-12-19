package com.sikaiverse.backend.landing.dto.request;


import lombok.Data;


@Data
public class CourseListRequest {

    private int courseId;

    private String level;

    private String category;

    private String title;

    private double rating;

}
