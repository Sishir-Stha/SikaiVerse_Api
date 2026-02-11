package com.sikaiverse.backend.shared.dto.request.privileged;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ModuleInsertRequest {

    @JsonProperty("courseId")
    private Integer courseId;

    @JsonProperty("moduleTitle")
    private String moduleTitle;

    @JsonProperty("description")
    private String description;

}
