package com.sikaiverse.backend.shared.dto.response.all;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RepliesData {

    private Long replyId;
    private Long replyUserId;
    private String replyUserFullname;
    private String replyUserRole;
    private String replyContent;
    private Integer replyLikes;
    private LocalDateTime replyCreatedAt;
    private LocalDateTime replyUpdatedAt;
}
