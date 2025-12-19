package com.sikaiverse.backend.admin.controller;

import com.sikaiverse.backend.admin.dto.response.dashboard.AdminDashboardData;
import com.sikaiverse.backend.admin.dto.response.dashboard.AdminDashboardResponse;
import com.sikaiverse.backend.admin.service.AdminDashboardService;
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

@Slf4j
@RestController
@RequestMapping(ApiConstants.ADMIN_BASE)
public class AdminDashboardController {


    private final AdminDashboardService dashboardService;

    @Autowired
    public AdminDashboardController(AdminDashboardService dashboardService){
        this.dashboardService = dashboardService;
    }

    @GetMapping("/getDashboardInfo")
    public ResponseEntity<?> getDashboardInfo(){
        try{
            AdminDashboardData data = dashboardService.getInfoDashboard();
            if(data != null){
                log.info("<< Dashboard Info loaded for Admin >>");
                return ResponseEntity.ok(new AdminDashboardResponse(StatusConstants.SUCCESS,data));
            }else{
                log.debug("<< Dashboard info load failed for Admin >>");
                return ResponseEntity.status(HttpConstants.FAILED).body(new ErrorMessage(StatusConstants.FAILURE,"Dashboard Info load failed due to invalid user"));
            }
        }catch (Exception e){
            log.error("Error occurred during login for Admin" );
            return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR).body(new ErrorMessage(StatusConstants.FAILURE,"Server Error "));
        }

    }


}
