package com.sikaiverse.backend.shared.mapper.all;

import com.sikaiverse.backend.shared.dto.response.all.DiscussionDto;
import com.sikaiverse.backend.shared.dto.response.all.ProfileData;
import com.sikaiverse.backend.shared.dto.response.all.RepliesData;
import com.sikaiverse.backend.shared.entity.all.DiscussionEntity;
import com.sikaiverse.backend.shared.entity.all.ProfileEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AllEntityToDto {
    public DiscussionDto discussionMapper(List<DiscussionEntity> entities) {
        DiscussionEntity firstEntity = entities.getFirst();
        List<RepliesData> repliesDataList = new ArrayList<>();

        for (DiscussionEntity entity : entities) {
            RepliesData replyDto = new RepliesData();
            replyDto.setReplyId(entity.getReplyId());
            replyDto.setReplyUserId(entity.getReplyUserId());
            replyDto.setReplyUserFullname(entity.getReplyUserFullname());
            replyDto.setReplyUserRole(entity.getReplyUserRole());
            replyDto.setReplyContent(entity.getReplyContent());
            replyDto.setReplyLikes(entity.getReplyLikes());
            replyDto.setReplyCreatedAt(entity.getReplyCreatedAt());
            replyDto.setReplyUpdatedAt(entity.getReplyUpdatedAt());
            repliesDataList.add(replyDto);
        }
        DiscussionDto response = new DiscussionDto();
        response.setPostId(firstEntity.getPostId());
        response.setPostTitle(firstEntity.getPostTitle());
        response.setPostContent(firstEntity.getPostContent());
        response.setPostUserId(firstEntity.getPostUserId());
        response.setPostUserFullname(firstEntity.getPostUserFullname());
        response.setPostUserRole(firstEntity.getPostUserRole());
        response.setPostLikes(firstEntity.getPostLikes());
        response.setPostCreatedAt(firstEntity.getPostCreatedAt());
        response.setPostUpdatedAt(firstEntity.getPostUpdatedAt());
        response.setRepliesDataList(repliesDataList);
        return response;
    }

    public ProfileData profileMapper(ProfileEntity entity){
        ProfileData response = new ProfileData();
        response.setFullName(entity.getFullName());
        response.setEmail(entity.getEmail());
        response.setAddress(entity.getAddress());
        response.setRole(entity.getRole());
        response.setPhoneNumber(entity.getPhoneNumber());
        return response;
    }

}
