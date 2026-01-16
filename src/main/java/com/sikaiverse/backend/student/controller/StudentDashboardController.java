package com.sikaiverse.backend.student.controller;


import com.sikaiverse.backend.common.constants.ApiConstants;
import com.sikaiverse.backend.common.constants.HttpConstants;
import com.sikaiverse.backend.common.constants.StatusConstants;
import com.sikaiverse.backend.common.utils.ErrorMessage;
import com.sikaiverse.backend.student.dto.request.StudentIdRequest;
import com.sikaiverse.backend.student.dto.response.dashboard.StudentDashboardInfoData;
import com.sikaiverse.backend.student.dto.response.dashboard.StudentDashboardInfoResponse;
import com.sikaiverse.backend.student.service.StudentDashboardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(ApiConstants.STUDENT_BASE)
public class StudentDashboardController {
    private final StudentDashboardService studentDashboardService;

    @Autowired
    public StudentDashboardController(StudentDashboardService studentDashboardService){
        this.studentDashboardService = studentDashboardService;
    }

    @PostMapping("/getDashboardInfo")
    public ResponseEntity<?>getDasboard(@RequestBody StudentIdRequest request){
        try{
            StudentDashboardInfoData data = studentDashboardService.getInfoDashboard(request);
            if(data != null ){
                log.info(" <<Dashboard Info Loaded for userId : "+ request.getUserId()+ " >> ");
                return ResponseEntity.ok(new StudentDashboardInfoResponse(StatusConstants.SUCCESS,data));
            }else{
                log.debug("<< Dashboard info load failed for userId : "+request.getUserId()+" >>");
                return ResponseEntity.status(HttpConstants.FAILED).body(new ErrorMessage(StatusConstants.FAILURE,"Dashboard Info load failed due to invalid user"));
            }
        }catch (Exception e){
            log.error("Error occurred during login for user: {}", request.getUserId(), e);
            return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR).body(new ErrorMessage(StatusConstants.FAILURE,"Server Error "));
        }

    }
}
