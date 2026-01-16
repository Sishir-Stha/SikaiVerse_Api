package com.sikaiverse.backend.student.dto.response.course;

import lombok.Data;

import java.util.List;

@Data
public class SideBarData {
    private int moduleId;
    private String moduleTitle;
    private List<SideBarLessonData> lessons;
}
