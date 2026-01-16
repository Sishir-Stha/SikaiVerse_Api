package com.sikaiverse.backend.student.service;

import com.sikaiverse.backend.student.dto.request.StudentIdRequest;
import com.sikaiverse.backend.student.dto.response.dashboard.StudentDashboardInfoData;
import com.sikaiverse.backend.student.entity.StudentDashboardInfoEntity;
import com.sikaiverse.backend.student.mapper.StudentEntityToDto;
import com.sikaiverse.backend.student.repository.StudentDashboardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StudentDashboardService {

    private final StudentDashboardRepository studentDashboardRepository;
    private final StudentEntityToDto mapper;

    @Autowired
    public StudentDashboardService(StudentDashboardRepository studentDashboardRepository, StudentEntityToDto mapper){
        this.studentDashboardRepository = studentDashboardRepository;
        this.mapper = mapper;
    }

    public StudentDashboardInfoData getInfoDashboard(StudentIdRequest request){

        List<StudentDashboardInfoEntity> entity = studentDashboardRepository.getDashboardInfo(request.getUserId());
        log.info("before :" + entity);
        if(entity != null && !entity.isEmpty()) {
            StudentDashboardInfoData response = mapper.dashboardMapper(entity);
            log.info("after"+ response);
            return response;
        }else{
            return null;
        }
    }
}
