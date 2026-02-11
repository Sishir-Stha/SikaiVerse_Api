package com.sikaiverse.backend.shared.dto.request.privileged;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LessonInsertRequest {


    @JsonProperty("moduleId")
    private Integer moduleId;

    @JsonProperty("lessonTitle")
    private String lessonTitle;

    @JsonProperty("lessonContent")
    private String lessonContent;

    @JsonProperty("description")
    private String description;

    @JsonProperty("contentType")
    private String contentType = "link";

    @JsonProperty("contentData")
    private String contentData;

    @JsonProperty("duration")
    private Integer duration = 0;
}
