package com.sikaiverse.backend.course.dto.request;


import lombok.Data;


@Data
public class CourseListRequest {

    private String level;

    private String category;

    private String title;

    private double rating;

}
