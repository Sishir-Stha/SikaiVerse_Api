package com.sikaiverse.backend.shared.service.all;

import com.sikaiverse.backend.shared.dto.request.all.*;
import com.sikaiverse.backend.shared.dto.response.all.DiscussionDto;
import com.sikaiverse.backend.shared.entity.all.DiscussionEntity;
import com.sikaiverse.backend.shared.mapper.all.AllEntityToDto;
import com.sikaiverse.backend.shared.repository.all.DiscussionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DiscussionService {

    private final DiscussionRepository discussionRepository;
    private final AllEntityToDto mapper;

    @Autowired
    public DiscussionService(DiscussionRepository discussionRepository,AllEntityToDto mapper){
        this.discussionRepository = discussionRepository;
        this.mapper = mapper;
    }

    public List<DiscussionDto> getDiscussion(CourseIdRequest request){

        List<DiscussionEntity> entities = discussionRepository.getDiscussionInfo(request.getCourseId());
        if(entities != null || !entities.isEmpty()){
            List<DiscussionDto> response = mapper.discussionMapper(entities);
            return response;
        }else{
            return null;
        }
    }

    public boolean likeDiscussionPost (PostIdRequest request){
        return discussionRepository.likeDiscussionPost(request.getPostId());
    }

    public boolean likeReplyPost (ReplyIdRequest request){
        return discussionRepository.likeReplyPost(request.getReplyId());
    }

    public boolean addPostReply(PostMessageRequest request){
        return discussionRepository.addPostReply(request.getCourseId(), request.getUserId(), request.getTitle(), request.getContent());
    }

    public boolean addReplies(ReplyMessageRequest request){
        return discussionRepository.addReplies(request.getPostId(), request.getUserId(), request.getContent());
    }

}
