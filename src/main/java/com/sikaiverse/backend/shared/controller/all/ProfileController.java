package com.sikaiverse.backend.shared.controller.all;

import com.sikaiverse.backend.common.constants.ApiConstants;
import com.sikaiverse.backend.common.constants.HttpConstants;
import com.sikaiverse.backend.common.constants.StatusConstants;
import com.sikaiverse.backend.common.utils.BooleanResponse;
import com.sikaiverse.backend.common.utils.ErrorMessage;
import com.sikaiverse.backend.shared.dto.request.all.AllUpdateUserRequest;
import com.sikaiverse.backend.shared.dto.request.all.UserIdRequest;
import com.sikaiverse.backend.shared.dto.response.all.ProfileData;
import com.sikaiverse.backend.shared.dto.response.all.ProfileDataResponse;
import com.sikaiverse.backend.shared.service.all.ProfileService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(ApiConstants.SHARED_ALL_BASE)
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController (ProfileService profileService){
        this.profileService = profileService;
    }

    @PostMapping("/getProfileInfo")
    public ResponseEntity<?> getProfileInfo (@Valid @RequestBody UserIdRequest request){
       try {
           ProfileData data = profileService.getProfileData(request);
           if (data != null) {
               log.info("  << Profile Info Fetched for userId : >>" + request.getUserId());
               return ResponseEntity.ok(new ProfileDataResponse(StatusConstants.SUCCESS, data));
           } else {
               log.debug(" << Profile Info fetching failed for userId : >>" + request.getUserId());
               return ResponseEntity.status(HttpConstants.FAILED).body(new ErrorMessage(StatusConstants.FAILURE, "Error while fetching the profile Info"));
           }
       }catch(Exception e){
            log.error("<< Error while fetching the profile info>>");
            return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR).body(new ErrorMessage(StatusConstants.FAILURE,"Internal Error while fetching the profile Info"));
        }
    }

    @PostMapping("/updateProfileInfo")
    public ResponseEntity<?> updateProfileInfo(@Valid @RequestBody AllUpdateUserRequest request){
        try{
            boolean data = profileService.updateProfileData(request);
            if(data) {
                log.info("  << Updating Profile Info for userId : " + request.getUserId()+ " >>");
                return ResponseEntity.ok(new BooleanResponse(StatusConstants.SUCCESS));
            }log.debug(" << Upadating Profile Info failed for userId : >>" + request.getUserId());
            return ResponseEntity.status(HttpConstants.FAILED).body(new ErrorMessage(StatusConstants.FAILURE, "Error while updating the profile Info"));
        }catch(Exception e){
        log.error("<< Error while updating the profile info>>");
        return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR).body(new ErrorMessage(StatusConstants.FAILURE,"Internal Error while updating the profile Info"));
    }

    }
}
