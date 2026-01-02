package com.sikaiverse.backend.shared.dto.request.all;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReplyIdRequest {
    @NotBlank(message = " Reply Id is required ")
    private int replyId;
}
