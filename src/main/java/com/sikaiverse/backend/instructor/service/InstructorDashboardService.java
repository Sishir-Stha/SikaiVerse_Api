package com.sikaiverse.backend.instructor.service;

import com.sikaiverse.backend.instructor.dto.request.InstructorIdRequest;
import com.sikaiverse.backend.instructor.dto.response.dashboard.InstructorDashboardData;
import com.sikaiverse.backend.instructor.entity.InstructorDashboardInfoEntity;
import com.sikaiverse.backend.instructor.mapper.InstructorEntityToDto;
import com.sikaiverse.backend.instructor.repository.InstructorDashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorDashboardService {

    private final InstructorDashboardRepository instructorDashboardRepository;
    private final InstructorEntityToDto mapper;

    @Autowired
    public InstructorDashboardService(InstructorDashboardRepository instructorDashboardRepository,InstructorEntityToDto mapper){
        this.instructorDashboardRepository = instructorDashboardRepository;
        this.mapper = mapper;
    }

    public InstructorDashboardData getInfoDashboard(InstructorIdRequest request){

        InstructorDashboardInfoEntity entity = instructorDashboardRepository.getDashboardInfo(request.getUserId());
        if(entity != null ) {
            InstructorDashboardData response = mapper.dashboardDataMapper(entity);
            return response;
        }else{
            return null;
        }
    }
}
