package com.sikaiverse.backend.student.controller;

import com.sikaiverse.backend.common.constants.ApiConstants;
import com.sikaiverse.backend.common.constants.HttpConstants;
import com.sikaiverse.backend.common.constants.StatusConstants;
import com.sikaiverse.backend.common.utils.ErrorMessage;
import com.sikaiverse.backend.student.dto.request.CourseIdRequest;
import com.sikaiverse.backend.student.dto.request.StudentIdRequest;
import com.sikaiverse.backend.student.dto.response.course.StudentCourseInfoData;
import com.sikaiverse.backend.student.dto.response.course.StudentCourseInfoResponse;
import com.sikaiverse.backend.student.dto.response.course.StudentEnrolledCourseData;
import com.sikaiverse.backend.student.dto.response.course.StudentEnrolledResponse;
import com.sikaiverse.backend.student.service.StudentCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(ApiConstants.STUDENT_BASE)
public class StudentCourseController {

    private final StudentCourseService studentCourseService;

    @Autowired
    public StudentCourseController(StudentCourseService studentCourseService) {
        this.studentCourseService = studentCourseService;
    }

    @PostMapping("/getCourseInfoList")
    public ResponseEntity<?> getCourseInfo(@RequestBody StudentIdRequest request) {
        try {
            List<StudentCourseInfoData> data = studentCourseService.getCourseInfo(request);
            if (data != null || !data.isEmpty()) {
                log.info(" << Course info is loaded for userId : " + request.getUserId() + " >> ");
                return ResponseEntity.ok(new StudentCourseInfoResponse(StatusConstants.SUCCESS, data));
            } else {
                log.debug("<< Course info load failed for userId : " + request.getUserId() + " >>");
                return ResponseEntity.status(HttpConstants.FAILED).body(new ErrorMessage(StatusConstants.FAILURE, "Dashboard Info load failed due to invalid user"));
            }

        } catch (Exception e) {
            log.error("Error occurred during loading data for user: {}", request.getUserId(), e);
            return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR).body(new ErrorMessage(StatusConstants.FAILURE, "Server Error "));
        }
    }

    @GetMapping("/getCourseDetails")
    public ResponseEntity<?> getCourseDetails(@RequestBody CourseIdRequest request) {
        try {
            StudentEnrolledCourseData data = studentCourseService.getEnrolledCourseInfo(request);
            if (data != null) {
                log.info(" << Course info is loaded for Course Id : " + request.getCourseId() + " >> ");
                return ResponseEntity.ok(new StudentEnrolledResponse(StatusConstants.SUCCESS, data));
            } else {
                log.debug("<< Course info load failed for Course Id : " + request.getCourseId() + " >>");
                return ResponseEntity.status(HttpConstants.FAILED).body(new ErrorMessage(StatusConstants.FAILURE, "Course Details failed to load"));
            }

        } catch (Exception e) {
            log.error("Error occurred during loading data for user: {}", request.getCourseId(), e);
            return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR).body(new ErrorMessage(StatusConstants.FAILURE, "Server Error "));
        }
    }
}



