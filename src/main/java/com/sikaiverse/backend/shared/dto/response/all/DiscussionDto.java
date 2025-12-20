package com.sikaiverse.backend.shared.dto.response.all;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class DiscussionDto {
    private Long postId;
    private String postTitle;
    private String postContent;
    private Long postUserId;
    private String postUserFullname;
    private String postUserRole;
    private Integer postLikes;
    private LocalDateTime postCreatedAt;
    private LocalDateTime postUpdatedAt;
    List<RepliesData> repliesDataList;
}
