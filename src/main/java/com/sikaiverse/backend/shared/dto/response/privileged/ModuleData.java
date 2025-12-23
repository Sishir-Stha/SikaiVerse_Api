package com.sikaiverse.backend.shared.dto.response.privileged;

import lombok.Data;

import java.util.List;

@Data
public class ModuleData {

    private Integer moduleId;
    private String moduleTitle;
    private Integer noOfLessons;
    private List<LessonData> lesson;

}
