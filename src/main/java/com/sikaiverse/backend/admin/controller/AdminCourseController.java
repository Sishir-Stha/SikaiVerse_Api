package com.sikaiverse.backend.admin.controller;

import com.sikaiverse.backend.admin.dto.response.course.AdminCourseData;
import com.sikaiverse.backend.admin.dto.response.course.AdminCourseResponse;
import com.sikaiverse.backend.admin.service.AdminCourseService;
import com.sikaiverse.backend.common.constants.ApiConstants;
import com.sikaiverse.backend.common.constants.HttpConstants;
import com.sikaiverse.backend.common.constants.StatusConstants;
import com.sikaiverse.backend.common.utils.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(ApiConstants.ADMIN_BASE)
public class AdminCourseController {

    private final AdminCourseService adminCourseService;

    @Autowired
    public AdminCourseController(AdminCourseService adminCourseService){
        this.adminCourseService = adminCourseService;
    }

    @GetMapping("/getCourseInfo")
    public ResponseEntity<?> getCourseInfo() {
        try {
            List<AdminCourseData> data = adminCourseService.getCourseInfo();
            if (data != null && !data.isEmpty()) {
                AdminCourseResponse response = new AdminCourseResponse(StatusConstants.SUCCESS, data);
                log.info(" << Course info is loaded for Admin >> " + response);
                return ResponseEntity.ok(response);
            } else {
                log.debug("<< Course info load failed for Admin >>");
                return ResponseEntity.status(HttpConstants.FAILED).body(new ErrorMessage(StatusConstants.FAILURE, "Course Info load failed due to invalid admin"));
            }
        } catch (Exception e) {
            log.error("Error occurred during loading data for Admin " + e);
            return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR).body(new ErrorMessage(StatusConstants.FAILURE, "Server Error "));
        }
    }

}
