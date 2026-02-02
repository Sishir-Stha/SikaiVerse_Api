package com.sikaiverse.backend.student.controller.course;

import com.sikaiverse.backend.common.constants.ApiConstants;
import com.sikaiverse.backend.common.constants.HttpConstants;
import com.sikaiverse.backend.common.constants.StatusConstants;
import com.sikaiverse.backend.common.utils.BooleanResponse;
import com.sikaiverse.backend.common.utils.ErrorMessage;
import com.sikaiverse.backend.student.dto.request.CourseIdRequest;
import com.sikaiverse.backend.student.dto.request.LearnLessonRequest;
import com.sikaiverse.backend.student.dto.request.LessonIdRequest;
import com.sikaiverse.backend.student.dto.response.course.*;
import com.sikaiverse.backend.student.entity.course.LessonEntity;
import com.sikaiverse.backend.student.service.course.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(ApiConstants.COURSE_BASE)
public class CourseController {
    private final CourseService service;
    @Autowired
    public CourseController(CourseService service){
        this.service = service;
    }

    @PostMapping("/getSideBar")
    public ResponseEntity<?> getSideBar (@RequestBody CourseIdRequest request){
        try{
            List<SideBarData> data = service.getSideBar(request);
            if(data != null || !data.isEmpty()){
                log.info("<< Side Bar Info Fetched for Course Detail page>>");
                return ResponseEntity.ok(new SideBarResponse(StatusConstants.SUCCESS,data));
            }else{
                log.debug("<<Error in getting the Side Bar Info from DB>>");
                return ResponseEntity.status(HttpConstants.FAILED).body(new ErrorMessage(StatusConstants.FAILURE,"Error while fetching the sidebar data from Database"));
            }
        }catch(Exception e){
            log.error("<<Error while fetching the Side Bar Details>>");
            return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR).body(new ErrorMessage(StatusConstants.FAILURE,"Internal Server Error while fetching the side bar"));
        }
    }

    @PostMapping("/getLessonDetails")
    public ResponseEntity<?> getEnrolledLessonDetails (@RequestBody LessonIdRequest request){
        try{
            EnrolledLessonData data = service.getLessonDetail(request);
            if(data != null){
                log.info("<< Enrolled Course Details Fetched >>");
                return ResponseEntity.ok(new EnrolledLessonResponse(StatusConstants.SUCCESS,data));
            }else{
                log.debug("<< Error in getting the Enrolled course details from DB >>");
                return ResponseEntity.status(HttpConstants.FAILED).body(new ErrorMessage(StatusConstants.FAILURE,"Error while fetching the Enrolled Course Details from Database"));
            }
        }catch(Exception e){
            log.error("<<Error while fetching the Enrolled Course Details>>");
            return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR).body(new ErrorMessage(StatusConstants.FAILURE,"Internal Server Error while fetching the enrolled course details"));
        }
    }

    @PostMapping("/setInProgress")
    public ResponseEntity<?> isProgress (@RequestBody LearnLessonRequest request){
        try{
            boolean isEnrolled = service.setInprogress(request);
            if(isEnrolled){
                log.info(" Set Course InProgress ");
                return ResponseEntity.ok(new BooleanResponse(StatusConstants.SUCCESS));
            }else{
                log.info(" Set Course InProgress Invalid from DB ");
                return ResponseEntity.status(HttpConstants.FAILED).body(new ErrorMessage(StatusConstants.FAILURE," Set Course InProgress Invalid from Db"));
            }
        }catch (Exception e) {
            log.error("Error occurred during setting course inprogress ", e);
            return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR).body(new ErrorMessage(StatusConstants.FAILURE, "Server Error during setting course inprogress "));
        }
    }

    @PostMapping("/setCompleted")
    public ResponseEntity<?> isEnrolled(@RequestBody LearnLessonRequest request){
        try{
            boolean isEnrolled = service.setCompleted(request);
            if(isEnrolled){
                log.info(" Set Course Completed ");
                return ResponseEntity.ok(new BooleanResponse(StatusConstants.SUCCESS));
            }else{
                log.info(" Set Course Completed Invalid from DB ");
                return ResponseEntity.status(HttpConstants.FAILED).body(new ErrorMessage(StatusConstants.FAILURE," Set Course Completed Invalid from Db"));
            }
        }catch (Exception e) {
            log.error("Error occurred during setting course Completed ", e);
            return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR).body(new ErrorMessage(StatusConstants.FAILURE, "Server Error during setting course completed"));
        }
    }
}
