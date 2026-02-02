package com.sikaiverse.backend.shared.dto.request.privileged;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateCourseInfoRequest {

    @NotBlank(message = " Course Id is required ")
    private Integer courseId;

    @NotBlank(message = " User Id is required ")
    private Integer userId;
    //  * these can be empty string
    private String courseTitle;
    private String description;
    private String level;
    private String category;
}
