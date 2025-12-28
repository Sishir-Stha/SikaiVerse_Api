package com.sikaiverse.backend.shared.dto.request.all;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PostIdRequest {
    @NotBlank(message = " Post Id is required ")
    private int postId;
}
