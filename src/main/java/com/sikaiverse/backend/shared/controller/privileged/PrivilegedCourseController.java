package com.sikaiverse.backend.shared.controller.privileged;

import com.sikaiverse.backend.common.constants.ApiConstants;
import com.sikaiverse.backend.common.constants.HttpConstants;
import com.sikaiverse.backend.common.constants.StatusConstants;
import com.sikaiverse.backend.common.utils.BooleanResponse;
import com.sikaiverse.backend.common.utils.ErrorMessage;
import com.sikaiverse.backend.shared.dto.request.all.CourseIdRequest;
import com.sikaiverse.backend.shared.dto.request.privileged.CourseInsertRequest;
import com.sikaiverse.backend.shared.dto.response.privileged.CourseData;
import com.sikaiverse.backend.shared.service.privileged.PrivilegedCourseService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(ApiConstants.SHARED_PRIVILEGED_BASE)
public class PrivilegedCourseController {

    private final PrivilegedCourseService privilegedCourseService;

    @Autowired
    public PrivilegedCourseController(PrivilegedCourseService privilegedCourseService){
        this.privilegedCourseService = privilegedCourseService;
    }

    @GetMapping("/getEditInfo")
    public ResponseEntity<?> getEditCourseInfo(@RequestBody CourseIdRequest request){
    log.info("request recieved "+request.getCourseId());
        CourseData response = privilegedCourseService.getEditCourseInfo(request);
        if(response != null) {
            return ResponseEntity.ok(response);
        }else {
            log.debug(" << Edit info fetch request failed for "+ request.getCourseId() +" >> ");
            return ResponseEntity.status(HttpConstants.FAILED).body(new ErrorMessage(StatusConstants.FAILURE, "Error occured in DB"));
        }
    }


    @PostMapping("/addCourse")
    public ResponseEntity<?> insertCourse(@Valid @RequestBody CourseInsertRequest request){
        try{
            Boolean isCreated = privilegedCourseService.addCourse(request);
            if(isCreated){
                log.info("<< Course inserted Sucessfully with title : " +request.getTitle() +" >>");
                return ResponseEntity.ok(new BooleanResponse(StatusConstants.SUCCESS));
            }else{
                log.debug("<< Failed in inserting the course >>");
                return ResponseEntity.status(HttpConstants.FAILED).body("Failed in inserting the course");
            }
        }catch(Exception e){
            log.error("Error while inserting the course of title  : {}",request.getTitle(), e);
            return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR).body(new ErrorMessage(StatusConstants.FAILURE, "Internal Server Error !!"));
        }
    }
}
