package com.sikaiverse.backend.shared.service.all;

import com.sikaiverse.backend.shared.dto.request.all.CourseIdRequest;
import com.sikaiverse.backend.shared.dto.request.all.PostIdRequest;
import com.sikaiverse.backend.shared.dto.request.all.ReplyIdRequest;
import com.sikaiverse.backend.shared.dto.response.all.DiscussionDto;
import com.sikaiverse.backend.shared.entity.all.DiscussionEntity;
import com.sikaiverse.backend.shared.mapper.all.AllEntityToDto;
import com.sikaiverse.backend.shared.repository.all.DiscussionRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
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

    public DiscussionDto getDiscussion(CourseIdRequest request){

        List<DiscussionEntity> entities = discussionRepository.getDiscussionInfo(request.getCourseId());
        if(entities != null && !entities.isEmpty()){
            DiscussionDto response = mapper.discussionMapper(entities);
            return response;
        }else{
            return null;
        }
    }

    public boolean likeDiscussionPost (PostIdRequest request){

        boolean liked = discussionRepository.likeDiscussionPost(request.getPostId());
        return liked;

    }

    public boolean likeReplyPost (ReplyIdRequest request){

        boolean liked = discussionRepository.likeReplyPost(request.getReplyId());
        return liked;

    }
}
