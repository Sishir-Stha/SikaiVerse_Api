package com.sikaiverse.backend.instructor.controller;

import com.sikaiverse.backend.common.constants.ApiConstants;
import com.sikaiverse.backend.common.constants.HttpConstants;
import com.sikaiverse.backend.common.constants.StatusConstants;
import com.sikaiverse.backend.common.utils.ErrorMessage;
import com.sikaiverse.backend.instructor.dto.request.InstructorIdRequest;
import com.sikaiverse.backend.instructor.dto.response.course.InstructorCourseInfoData;
import com.sikaiverse.backend.instructor.dto.response.course.InstructorCourseInfoResponse;
import com.sikaiverse.backend.instructor.service.InstructorCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(ApiConstants.INSTRUCTOR_BASE)
public class InstructorCourseController {

    private final InstructorCourseService instructorCourseService;

    @Autowired
    public InstructorCourseController(InstructorCourseService instructorCourseService){
        this.instructorCourseService = instructorCourseService;
    }

    @PostMapping("/getCourseInfo")
    public ResponseEntity<?> getCourseInfo(@RequestBody InstructorIdRequest request) {
        try {
            List<InstructorCourseInfoData> data = instructorCourseService.getCourseInfo(request);
            if (data != null && !data.isEmpty()) {
                log.info(" << Course info is loaded for InstructorId : " + request.getUserId() + " >> ");
                return ResponseEntity.ok(new InstructorCourseInfoResponse(StatusConstants.SUCCESS, data));
            } else {
                log.debug("<< Course info load failed for InstructorId : " + request.getUserId() + " >>");
                return ResponseEntity.status(HttpConstants.FAILED).body(new ErrorMessage(StatusConstants.FAILURE, "Course Info load failed due to invalid user"));
            }
        } catch (Exception e) {
            log.error("Error occurred during loading data for user: {}", request.getUserId(), e);
            return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR).body(new ErrorMessage(StatusConstants.FAILURE, "Server Error "));
        }
    }

}
