package com.sikaiverse.backend.shared.mapper.all;

import com.sikaiverse.backend.shared.dto.response.all.DiscussionDto;
import com.sikaiverse.backend.shared.dto.response.all.ProfileData;
import com.sikaiverse.backend.shared.dto.response.all.RepliesData;
import com.sikaiverse.backend.shared.entity.all.DiscussionEntity;
import com.sikaiverse.backend.shared.entity.all.ProfileEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class AllEntityToDto {

    private final ObjectMapper mapper;

    public List<DiscussionDto> discussionMapper(List<DiscussionEntity> entities) {
        String jsonReplies;
        List<DiscussionDto> results = new ArrayList<>();
        for (DiscussionEntity entity : entities) {
            DiscussionDto response = new DiscussionDto();
            response.setPostId(entity.getPostId());
            response.setPostTitle(entity.getPostTitle());
            response.setPostContent(entity.getPostContent());
            response.setPostUserId(entity.getPostUserId());
            response.setPostUserFullname(entity.getPostUserFullname());
            response.setPostUserRole(entity.getPostUserRole());
            response.setPostLikes(entity.getPostLikes());
            response.setPostCreatedAt(entity.getPostCreatedAt());
            response.setPostUpdatedAt(entity.getPostUpdatedAt());
            jsonReplies = entity.getReplies();
            List<RepliesData> replies = parseReplies(jsonReplies);
            response.setRepliesDataList(replies);
            results.add(response);
        }
        return results;
    }

    public List<RepliesData> parseReplies(String jsonReplies){
        if(jsonReplies == null || jsonReplies.isBlank() || jsonReplies.equals("[]")) {
            log.debug("no replies for this post ! ");
            return new ArrayList<>();
        }else{
            List<RepliesData> replies = mapper.readValue(
                    jsonReplies,
                    new TypeReference<List<RepliesData>>() {
                    }
            );
            log.info("Json is parsed ! ");
            return replies;
        }
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
