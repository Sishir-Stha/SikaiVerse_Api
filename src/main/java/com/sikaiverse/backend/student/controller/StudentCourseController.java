package com.sikaiverse.backend.student.controller;

import com.sikaiverse.backend.common.constants.ApiConstants;
import com.sikaiverse.backend.common.constants.HttpConstants;
import com.sikaiverse.backend.common.constants.StatusConstants;
import com.sikaiverse.backend.common.utils.ErrorMessage;
import com.sikaiverse.backend.student.dto.request.StudentIdRequest;
import com.sikaiverse.backend.student.dto.response.course.StudentCourseInfoData;
import com.sikaiverse.backend.student.dto.response.course.StudentCourseInfoResponse;
import com.sikaiverse.backend.student.service.StudentCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(ApiConstants.STUDENT_BASE)
public class StudentCourseController {

    private final StudentCourseService studentCourseService;

    @Autowired
    public StudentCourseController(StudentCourseService studentCourseService){
        this.studentCourseService = studentCourseService;
    }

    @GetMapping("/getCourseInfo")
    public ResponseEntity<?> getCourseInfo(@RequestBody StudentIdRequest request){
        try{
            log.info("request"+ request.getUserId());
            List<StudentCourseInfoData> data = studentCourseService.getCourseInfo(request);
            if(data != null && !data.isEmpty()){
                log.info(" << Course info is loaded for userId : "+ request.getUserId() +" >> ");
                return ResponseEntity.ok(new StudentCourseInfoResponse(StatusConstants.SUCCESS,data));
            }else{
                log.debug("<< Course info load failed for userId : "+request.getUserId()+" >>");
                return ResponseEntity.status(HttpConstants.FAILED).body(new ErrorMessage(StatusConstants.FAILURE,"Dashboard Info load failed due to invalid user"));
            }

        }catch (Exception e){
            log.error("Error occurred during loading data for user: {}", request.getUserId(), e);
            return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR).body(new ErrorMessage(StatusConstants.FAILURE,"Server Error "));
        }
    }

}
