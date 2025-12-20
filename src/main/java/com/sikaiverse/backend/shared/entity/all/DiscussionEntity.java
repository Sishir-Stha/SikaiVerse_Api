package com.sikaiverse.backend.shared.entity.all;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class DiscussionEntity {

    // -------- POST --------
    @Id
    @Column(name = "post_id")
    private Long postId;

    @Column(name = "post_title")
    private String postTitle;

    @Column(name = "post_content")
    private String postContent;

    @Column(name = "post_user_id")
    private Long postUserId;

    @Column(name = "post_user_fullname")
    private String postUserFullname;

    @Column(name = "post_user_role")
    private String postUserRole;

    @Column(name = "post_likes")
    private Integer postLikes;

    @Column(name = "post_created_at")
    private LocalDateTime postCreatedAt;

    @Column(name = "post_updated_at")
    private LocalDateTime postUpdatedAt;

    // -------- REPLY --------
    @Column(name = "reply_id")
    private Long replyId;

    @Column(name = "reply_user_id")
    private Long replyUserId;

    @Column(name = "reply_user_fullname")
    private String replyUserFullname;

    @Column(name = "reply_user_role")
    private String replyUserRole;

    @Column(name = "reply_content")
    private String replyContent;

    @Column(name = "reply_likes")
    private Integer replyLikes;

    @Column(name = "reply_created_at")
    private LocalDateTime replyCreatedAt;

    @Column(name = "reply_updated_at")
    private LocalDateTime replyUpdatedAt;
}
