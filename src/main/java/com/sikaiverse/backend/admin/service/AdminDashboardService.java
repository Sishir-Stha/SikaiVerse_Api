package com.sikaiverse.backend.admin.service;

import com.sikaiverse.backend.admin.dto.response.dashboard.AdminDashboardData;
import com.sikaiverse.backend.admin.entity.AdminDashboardInfoEntity;
import com.sikaiverse.backend.admin.mapper.AdminEntityToDto;
import com.sikaiverse.backend.admin.repository.AdminDashboardRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminDashboardService {
    private final AdminDashboardRespository adminDashboardRepository;
    private final AdminEntityToDto mapper;

    @Autowired
    public AdminDashboardService(AdminDashboardRespository adminDashboardRepository, AdminEntityToDto mapper){
        this.adminDashboardRepository = adminDashboardRepository;
        this.mapper = mapper;
    }

    public AdminDashboardData getInfoDashboard(){

        AdminDashboardInfoEntity entity = adminDashboardRepository.getDashboardInfo();
        if(entity != null ) {
            AdminDashboardData response = mapper.dashboardDataMapper(entity);
            return response;
        }else{
            return null;
        }
    }
    
    
}
