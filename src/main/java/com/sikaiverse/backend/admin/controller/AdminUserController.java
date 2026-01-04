package com.sikaiverse.backend.admin.controller;

import com.sikaiverse.backend.admin.dto.request.AdminUpdateUserRequest;
import com.sikaiverse.backend.admin.dto.response.user.AdminUserData;
import com.sikaiverse.backend.admin.dto.response.user.AdminUserResponse;
import com.sikaiverse.backend.admin.service.AdminUserService;
import com.sikaiverse.backend.common.constants.ApiConstants;
import com.sikaiverse.backend.common.constants.HttpConstants;
import com.sikaiverse.backend.common.constants.StatusConstants;
import com.sikaiverse.backend.common.utils.BooleanResponse;
import com.sikaiverse.backend.common.utils.ErrorMessage;
import com.sikaiverse.backend.shared.dto.request.all.AllUpdateUserRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(ApiConstants.ADMIN_BASE)
public class AdminUserController {

    private final AdminUserService adminUserService;

    @Autowired
    public AdminUserController(AdminUserService adminUserService){
        this.adminUserService = adminUserService;
    }

    @GetMapping("/getUserList")
    public ResponseEntity<?> getAllUser(){
    try {
        List<AdminUserData> data = adminUserService.getUserInfo();
        if (data != null && !data.isEmpty()) {
            log.info(" << User List retrive request recieved >> ");
            return ResponseEntity.ok(new AdminUserResponse(StatusConstants.SUCCESS, data));

        } else {
            log.debug("<<  User List retireved request failed (Error occured in DB) >>");
            return ResponseEntity.status(HttpConstants.FAILED).body(new ErrorMessage(StatusConstants.FAILURE, "Error occured in DB"));
        }
    }catch(Exception e){
        log.error("Error while retriving user list ");
        return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR).body(new ErrorMessage(StatusConstants.FAILURE, "Internal Server Error !!"));
    }
    }

    @PostMapping("/updateProfileInfo")
    public ResponseEntity<?> updateProfileInfo(@Valid @RequestBody AdminUpdateUserRequest request) {
        try {
            boolean data = adminUserService.updateProfileData(request);
            if (data) {
                log.info("  << Updating Profile Info for userId : " + request.getUserId() + " >>");
                return ResponseEntity.ok(new BooleanResponse(StatusConstants.SUCCESS));
            }
            log.debug(" << Upadating Profile Info failed for userId : >>" + request.getUserId());
            return ResponseEntity.status(HttpConstants.FAILED).body(new ErrorMessage(StatusConstants.FAILURE, "Error while updating the profile Info"));
        } catch (Exception e) {
            log.error("<< Error while updating the profile info>>");
            return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR).body(new ErrorMessage(StatusConstants.FAILURE, "Internal Error while updating the profile Info"));
        }
    }
}
