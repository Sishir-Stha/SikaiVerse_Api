package com.sikaiverse.backend.shared.controller.all;

import com.sikaiverse.backend.common.constants.ApiConstants;
import com.sikaiverse.backend.common.constants.HttpConstants;
import com.sikaiverse.backend.common.constants.StatusConstants;
import com.sikaiverse.backend.common.utils.BooleanResponse;
import com.sikaiverse.backend.common.utils.ErrorMessage;
import com.sikaiverse.backend.shared.dto.request.all.CourseIdRequest;
import com.sikaiverse.backend.shared.dto.request.all.PostIdRequest;
import com.sikaiverse.backend.shared.dto.request.all.ReplyIdRequest;
import com.sikaiverse.backend.shared.dto.response.all.DiscussionDto;
import com.sikaiverse.backend.shared.dto.response.all.DiscussionResponse;
import com.sikaiverse.backend.shared.service.all.DiscussionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(ApiConstants.SHARED_ALL_BASE)
public class DiscussionController {

    private final DiscussionService discussionService;

    public DiscussionController(DiscussionService discussionService){
        this.discussionService = discussionService;
    }

    @GetMapping("/getDiscussion")
    public ResponseEntity<?> getDiscussion(@RequestBody CourseIdRequest request){
        try{

            List<DiscussionDto> response = discussionService.getDiscussion(request);
            if(response != null){
                log.info(" << Discussion list retrived request recieved for "+ request.getCourseId() +" >> ");
                return ResponseEntity.ok(new DiscussionResponse(StatusConstants.SUCCESS,response));
            }else {
                log.debug(" << Discussion list retrived failed for "+ request.getCourseId() +" >> ");
                return ResponseEntity.status(HttpConstants.FAILED).body(new ErrorMessage(StatusConstants.FAILURE, "Error occured in DB"));
            }
        }catch(Exception e){
            log.error("Error while retriving Discussion list ");
            return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR).body(new ErrorMessage(StatusConstants.FAILURE, "Internal Server Error !!"));
        }
    }

    @PutMapping("/likeDiscussion")
    public ResponseEntity<?> likeDiscussionPost(@RequestBody PostIdRequest request){
       try {
           boolean liked = discussionService.likeDiscussionPost(request);
           if (liked) {
               log.info(" << Discussion Liked request recieved " + request.getPostId() +" >> ");
               return ResponseEntity.ok(new BooleanResponse(StatusConstants.SUCCESS));
           } else {
               log.debug(" << Discussion Liked request failed for "+ request.getPostId() +" >> ");
               return ResponseEntity.status(HttpConstants.FAILED).body(new ErrorMessage(StatusConstants.FAILURE, "Error occured in DB"));
           }
       }catch(Exception e){
           log.error("Error while retriving Discussion list ");
           return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR).body(new ErrorMessage(StatusConstants.FAILURE, "Internal Server Error !!"));
       }
    }

    @PutMapping("/likeReply")
    public ResponseEntity<?> likeReplyPost(@RequestBody ReplyIdRequest request){
        try {
            boolean liked = discussionService.likeReplyPost(request);
            if (liked) {
                log.info(" << Reply Liked request recieved " + request.getReplyId() +" >> ");
                return ResponseEntity.ok(new BooleanResponse(StatusConstants.SUCCESS));
            } else {
                log.debug(" << Reply Liked request failed for "+ request.getReplyId() +" >> ");
                return ResponseEntity.status(HttpConstants.FAILED).body(new ErrorMessage(StatusConstants.FAILURE, "Error occured in DB"));
            }
        }catch(Exception e){
            log.error("Error while retriving Discussion list ");
            return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR).body(new ErrorMessage(StatusConstants.FAILURE, "Internal Server Error !!"));
        }
    }

}
