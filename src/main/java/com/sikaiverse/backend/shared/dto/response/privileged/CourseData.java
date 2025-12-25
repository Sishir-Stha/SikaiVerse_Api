package com.sikaiverse.backend.shared.dto.response.privileged;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
public class CourseData {

    private Integer courseId;
    private String courseTitle;
    private String description;
    private String instructorName;
    private String category;
    private String level;
    List<ModuleData> modules;
}
