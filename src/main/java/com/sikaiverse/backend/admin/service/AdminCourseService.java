package com.sikaiverse.backend.admin.service;


import com.sikaiverse.backend.admin.dto.response.course.AdminCourseData;
import com.sikaiverse.backend.admin.dto.response.course.AdminCourseListData;
import com.sikaiverse.backend.admin.entity.AdminCourseInfoEntity;
import com.sikaiverse.backend.admin.entity.AdminCourseListEntity;
import com.sikaiverse.backend.admin.mapper.AdminEntityToDto;
import com.sikaiverse.backend.admin.repository.AdminCourseRespository;
import com.sikaiverse.backend.instructor.dto.request.InstructorIdRequest;
import com.sikaiverse.backend.instructor.dto.response.course.InstructorCourseListData;
import com.sikaiverse.backend.instructor.entity.InstructorCourseListEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AdminCourseService {

    private final AdminCourseRespository adminCourseRespository;
    private final AdminEntityToDto mapper;

    @Autowired
    public AdminCourseService(AdminCourseRespository adminCourseRepository, AdminEntityToDto mapper){
        this.adminCourseRespository = adminCourseRepository;
        this.mapper = mapper;
    }

    public List<AdminCourseData> getCourseInfo (){
        List<AdminCourseInfoEntity> entity = adminCourseRespository.getCourseInfo();
        if(entity != null && !entity.isEmpty()) {
            List<AdminCourseData> response = mapper.courseDataMapper(entity);
            return response;
        }else {
            return null;
        }
    }
    public List<AdminCourseListData> getCourseList(){
        List<AdminCourseListEntity> entity = adminCourseRespository.getCourseList();
        //log.info("result"+entity);
        if(entity != null && !entity.isEmpty()){
            List<AdminCourseListData> response = mapper.courseListDataMapper(entity);
            return response;
        }else{
            return null ;
        }
    }

}
