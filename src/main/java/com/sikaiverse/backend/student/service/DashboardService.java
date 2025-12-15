package com.sikaiverse.backend.student.service;

import com.sikaiverse.backend.student.dto.request.UserIdRequest;
import com.sikaiverse.backend.student.dto.response.DashboardCourseData;
import com.sikaiverse.backend.student.dto.response.DashboardInfoData;
import com.sikaiverse.backend.student.dto.response.DashboardInfoResponse;
import com.sikaiverse.backend.student.entity.DashboardInfoEntity;
import com.sikaiverse.backend.student.mapper.DashboardEntityToDto;
import com.sikaiverse.backend.student.repository.DashboardRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    private final DashboardRespository dashboardRespository;
    private final DashboardEntityToDto mapper;

    @Autowired
    public DashboardService(DashboardRespository dashboardRespository, DashboardEntityToDto mapper){
        this.dashboardRespository = dashboardRespository;
        this.mapper = mapper;
    }

    public DashboardInfoData getInfoDashboard(UserIdRequest request){
        List<DashboardInfoEntity> entity = dashboardRespository.getDashboardInfo(request.getUserId());
        DashboardInfoData response = mapper.dashboardMapper(entity);
        return response;
    }
}
