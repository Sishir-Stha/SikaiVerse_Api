package com.sikaiverse.backend.shared.controller.privileged;

import com.sikaiverse.backend.common.constants.ApiConstants;
import com.sikaiverse.backend.common.constants.HttpConstants;
import com.sikaiverse.backend.common.constants.StatusConstants;
import com.sikaiverse.backend.common.utils.ErrorMessage;
import com.sikaiverse.backend.shared.dto.request.all.CourseIdRequest;
import com.sikaiverse.backend.shared.dto.response.privileged.CourseData;
import com.sikaiverse.backend.shared.entity.privileged.EditCourseInfoEntity;
import com.sikaiverse.backend.shared.service.privileged.EditCouseInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(ApiConstants.SHARED_PRIVILEGED_BASE)
public class EditCourseInfoController {

    private final EditCouseInfoService editCouseInfoService;

    @Autowired
    public EditCourseInfoController(EditCouseInfoService editCouseInfoService){
        this.editCouseInfoService = editCouseInfoService;
    }

    @GetMapping("/getEditInfo")
    public ResponseEntity<?> getEditCourseInfo(@RequestBody CourseIdRequest request){
    log.info("request recieved "+request.getCourseId());
        CourseData response = editCouseInfoService.getEditCourseInfo(request);
        if(response != null) {
            return ResponseEntity.ok(response);
        }else {
            log.debug(" << Edit info fetch request failed for "+ request.getCourseId() +" >> ");
            return ResponseEntity.status(HttpConstants.FAILED).body(new ErrorMessage(StatusConstants.FAILURE, "Error occured in DB"));
        }
    }
}
