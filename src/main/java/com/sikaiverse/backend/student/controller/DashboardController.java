package com.sikaiverse.backend.student.controller;


import com.sikaiverse.backend.common.constants.ApiConstants;
import com.sikaiverse.backend.common.constants.HttpConstants;
import com.sikaiverse.backend.common.constants.StatusConstants;
import com.sikaiverse.backend.common.utils.ErrorMessage;
import com.sikaiverse.backend.student.dto.request.UserIdRequest;
import com.sikaiverse.backend.student.dto.response.DashboardCourseData;
import com.sikaiverse.backend.student.dto.response.DashboardInfoData;
import com.sikaiverse.backend.student.dto.response.DashboardInfoResponse;
import com.sikaiverse.backend.student.service.DashboardService;
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
public class DashboardController {
    private final DashboardService dashboardService;

    @Autowired
    public DashboardController(DashboardService dashboardService){
        this.dashboardService = dashboardService;
    }

    @GetMapping("/getInfo")
    public ResponseEntity<?>getDasboard(@RequestBody UserIdRequest request){
        try{
            DashboardInfoData data = dashboardService.getInfoDashboard(request);
            if(data != null ){
                log.info(" <<Dashboard Info Loaded for userId : "+ request.getUserId()+ " >> ");
                return ResponseEntity.ok(new DashboardInfoResponse("true",data));
            }else{
                log.debug("<< Dashboard info load failed for userId : "+request.getUserId()+" >>");
                return ResponseEntity.status(HttpConstants.FAILED).body(new ErrorMessage("false","Dashboard Info load failed due to invalid user"));
            }
        }catch (Exception e){
            log.error("Error occurred during login for user: {}", request.getUserId(), e);
            return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR).body(new ErrorMessage(StatusConstants.FAILURE,"Server Error "));
        }

    }
}
