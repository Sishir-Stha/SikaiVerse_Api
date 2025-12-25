package com.sikaiverse.backend.admin.service;

import com.sikaiverse.backend.admin.dto.response.user.AdminUserData;
import com.sikaiverse.backend.admin.entity.AdminUserInfoEntity;
import com.sikaiverse.backend.admin.mapper.AdminEntityToDto;
import com.sikaiverse.backend.admin.repository.AdminUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserService {

    private final AdminUserRepository adminUserRepository;
    private final AdminEntityToDto mapper;

    public AdminUserService (AdminUserRepository adminUserRepository,AdminEntityToDto mapper){
        this.adminUserRepository = adminUserRepository;
        this.mapper = mapper;
    }

    public List<AdminUserData> getUserInfo(){

        List<AdminUserInfoEntity> entities = adminUserRepository.getUserInfo();
        if(entities != null && !entities.isEmpty()){
            List<AdminUserData> response = mapper.userDataMapper(entities);
            return response;
        }else {
            return null;
        }
    }

}
