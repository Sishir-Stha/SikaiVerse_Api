package com.sikaiverse.backend.course.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class CourseListResponse {
    private String success;
    private List<CourseDataResponse> data;
}
