package com.sikaiverse.backend.shared.controller.all;

import com.sikaiverse.backend.common.constants.ApiConstants;
import com.sikaiverse.backend.common.constants.HttpConstants;
import com.sikaiverse.backend.common.constants.StatusConstants;
import com.sikaiverse.backend.common.utils.ErrorMessage;
import com.sikaiverse.backend.shared.dto.request.all.CourseIdRequest;
import com.sikaiverse.backend.shared.dto.response.all.DiscussionDto;
import com.sikaiverse.backend.shared.dto.response.all.DiscussionResponse;
import com.sikaiverse.backend.shared.service.all.DiscussionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.ldap.PagedResultsControl;

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
            DiscussionDto response = discussionService.getDiscussion(request);
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

}
