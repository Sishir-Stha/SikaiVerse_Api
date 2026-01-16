package com.sikaiverse.backend.student.dto.response.course;

import lombok.Data;

@Data
public class StudentEnrolledModuleData {
    private Integer moduleId;
    private String moduleTitle;
    private Integer moduleOrderNo;
    private Integer noOfLesson;

}
