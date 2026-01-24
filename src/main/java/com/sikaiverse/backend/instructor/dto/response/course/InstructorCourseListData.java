package com.sikaiverse.backend.instructor.dto.response.course;

import lombok.Data;

@Data
public class InstructorCourseListData {

    private int courseId;
    private String courseTitle;
    private int noOfLessons;
}
