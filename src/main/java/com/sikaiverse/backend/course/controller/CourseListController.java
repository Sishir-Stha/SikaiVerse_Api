package com.sikaiverse.backend.course.controller;

import com.sikaiverse.backend.common.constants.ApiConstants;
import com.sikaiverse.backend.common.constants.HttpConstants;
import com.sikaiverse.backend.common.constants.StatusConstants;
import com.sikaiverse.backend.common.utils.ErrorMessage;
import com.sikaiverse.backend.course.dto.request.CourseInsertRequest;
import com.sikaiverse.backend.course.dto.request.CourseListRequest;
import com.sikaiverse.backend.course.dto.response.CourseDataResponse;
import com.sikaiverse.backend.course.dto.response.CourseListResponse;
import com.sikaiverse.backend.course.service.CourseListService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(ApiConstants.COURSE_LIST_BASE)
public class CourseListController {

    private final CourseListService courseListService;

    @Autowired
    public CourseListController(CourseListService courseListService){
        this.courseListService = courseListService;
    }

    @PostMapping("/list")
    public ResponseEntity<?> listFilteredCourse (@Valid @RequestBody CourseListRequest request){
        try {
            List<CourseDataResponse> data = courseListService.listFilteredCourse(request);
            if(data != null) {
                log.info("<< Course Filtered List Fetched >>");
                return ResponseEntity.ok(new CourseListResponse(StatusConstants.SUCCESS, data));
            }else{
                log.debug("<< Error in fetching the Filtered Courses >>");
                return ResponseEntity.status(HttpConstants.FAILED).body(new CourseListResponse(StatusConstants.FAILURE,data));
            }

        }catch(Exception e){
            log.error("Error while fetching the course of category : {}",request.getCategory(), e);
            return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR).body(new ErrorMessage(StatusConstants.FAILURE, "Internal Server Error !!"));
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> insertCourse(@Valid @RequestBody CourseInsertRequest request){
        try{
            log.info(""+request);
            Boolean isCreated = courseListService.addCourse(request);
            String response = "success : " +isCreated;
            if(isCreated){
                log.info("<< Course inserted Sucessfully with title : " +request.getTitle() +" >>");
                return ResponseEntity.ok(response);
            }else{
                log.debug("<< Failed in inserting the course >>");
                return ResponseEntity.status(HttpConstants.FAILED).body(response);
            }
        }catch(Exception e){
            log.error("Error while inserting the course of title  : {}",request.getTitle(), e);
            return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR).body(new ErrorMessage(StatusConstants.FAILURE, "Internal Server Error !!"));
        }
    }
}
