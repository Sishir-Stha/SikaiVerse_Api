package com.sikaiverse.backend.student.controller.course;

import com.sikaiverse.backend.common.constants.ApiConstants;
import com.sikaiverse.backend.common.constants.HttpConstants;
import com.sikaiverse.backend.common.constants.StatusConstants;
import com.sikaiverse.backend.common.utils.ErrorMessage;
import com.sikaiverse.backend.student.dto.request.CourseIdRequest;
import com.sikaiverse.backend.student.dto.response.course.SideBarData;
import com.sikaiverse.backend.student.dto.response.course.SideBarResponse;
import com.sikaiverse.backend.student.service.course.CourseService;
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
@RequestMapping(ApiConstants.COURSE_BASE)
public class CourseController {
    private final CourseService service;
    @Autowired
    public CourseController(CourseService service){
        this.service = service;
    }

    @GetMapping("/getSideBar")
    public ResponseEntity<?> getSideBar (@RequestBody CourseIdRequest request){
        try{
            List<SideBarData> data = service.getSideBar(request);
            if(data != null || !data.isEmpty()){
                log.info("<< Side Bar Info Fetched for Course Detail page>>");
                return ResponseEntity.ok(new SideBarResponse(StatusConstants.SUCCESS,data));
            }else{
                log.debug("<<Error in getting the Side Bar Info for DB>>");
                return ResponseEntity.status(HttpConstants.FAILED).body(new ErrorMessage(StatusConstants.FAILURE,"Error while fetching the sidebar data from Databasee"));
            }
        }catch(Exception e){
            log.error("<<Error while fetching the Side Bar Details>>");
            return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR).body(new ErrorMessage(StatusConstants.FAILURE,"Internal Server Error while fetching the side bar"));
        }
    }

}
