package com.sikaiverse.backend.shared.dto.request.all;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ReplyMessageRequest {

    @Column(name = "postId")
    private int postId;
    @Column(name = "userId")
    private int userId;
    @Column(name = "content")
    private String content;

}
