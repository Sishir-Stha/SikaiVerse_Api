package com.sikaiverse.backend.shared.dto.request.all;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class PostMessageRequest {

    @Column(name = "courseId")
    private int courseId;
    @Column(name = "userId")
    private int userId;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
}
