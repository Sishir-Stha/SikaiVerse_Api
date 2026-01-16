package com.sikaiverse.backend.admin.service;


import com.sikaiverse.backend.admin.dto.response.course.AdminCourseData;
import com.sikaiverse.backend.admin.dto.response.course.AdminCourseListData;
import com.sikaiverse.backend.admin.entity.AdminCourseInfoEntity;
import com.sikaiverse.backend.admin.entity.AdminCourseListEntity;
import com.sikaiverse.backend.admin.mapper.AdminEntityToDto;
import com.sikaiverse.backend.admin.repository.AdminCourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AdminCourseService {

    private final AdminCourseRepository adminCourseRepository;
    private final AdminEntityToDto mapper;

    @Autowired
    public AdminCourseService(AdminCourseRepository adminCourseRepository, AdminEntityToDto mapper){
        this.adminCourseRepository = adminCourseRepository;
        this.mapper = mapper;
    }

    public List<AdminCourseData> getCourseInfo (){
        List<AdminCourseInfoEntity> entity = adminCourseRepository.getCourseInfo();
        if(entity != null || !entity.isEmpty()) {
            List<AdminCourseData> response = mapper.courseDataMapper(entity);
            return response;
        }else {
            return null;
        }
    }
    public List<AdminCourseListData> getCourseList(){
        List<AdminCourseListEntity> entity = adminCourseRepository.getCourseList();
        //log.info("result"+entity);
        if(entity != null || !entity.isEmpty()){
            List<AdminCourseListData> response = mapper.courseListDataMapper(entity);
            return response;
        }else{
            return null ;
        }
    }

}
