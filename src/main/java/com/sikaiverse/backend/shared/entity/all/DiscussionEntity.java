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

    @Column(name = "replies")
    private String replies;


}
