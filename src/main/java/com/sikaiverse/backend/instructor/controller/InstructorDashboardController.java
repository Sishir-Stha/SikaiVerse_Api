package com.sikaiverse.backend.instructor.controller;

import com.sikaiverse.backend.common.constants.ApiConstants;
import com.sikaiverse.backend.common.constants.HttpConstants;
import com.sikaiverse.backend.common.constants.StatusConstants;
import com.sikaiverse.backend.common.utils.ErrorMessage;
import com.sikaiverse.backend.instructor.dto.request.InstructorIdRequest;
import com.sikaiverse.backend.instructor.dto.response.dashboard.InstructorDashboardData;
import com.sikaiverse.backend.instructor.dto.response.dashboard.InstructorDashboardResponse;
import com.sikaiverse.backend.instructor.service.InstructorDashboardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(ApiConstants.INSTRUCTOR_BASE)
public class InstructorDashboardController {

    private final InstructorDashboardService dashboardService;

    @Autowired
    public InstructorDashboardController(InstructorDashboardService dashboardService){
        this.dashboardService = dashboardService;
    }

    @PostMapping("/getDashboardInfo")
    public ResponseEntity<?> getDashboardInfo(@RequestBody InstructorIdRequest request){
        try{
            InstructorDashboardData data = dashboardService.getInfoDashboard(request);
           if(data != null){
               log.info("<< Dashboard Info loaded for Instructor Id : " + request.getUserId()+">>");
                return ResponseEntity.ok(new InstructorDashboardResponse("true",data));
           }else{
                log.debug("<< Dashboard info load failed for InstructorId : "+request.getUserId()+" >>");
                return ResponseEntity.status(HttpConstants.FAILED).body(new ErrorMessage(StatusConstants.FAILURE,"Dashboard Info load failed due to invalid user"));
            }
        }catch (Exception e){
            log.error("Error occurred during login for Instructor : {}", request.getUserId(), e);
            return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR).body(new ErrorMessage(StatusConstants.FAILURE,"Server Error "));
        }

    }
}
