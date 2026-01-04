package com.sikaiverse.backend.shared.service.all;

import com.sikaiverse.backend.shared.dto.request.all.AllUpdateUserRequest;
import com.sikaiverse.backend.shared.dto.request.all.UserIdRequest;
import com.sikaiverse.backend.shared.dto.response.all.ProfileData;
import com.sikaiverse.backend.shared.entity.all.ProfileEntity;
import com.sikaiverse.backend.shared.mapper.all.AllEntityToDto;
import com.sikaiverse.backend.shared.repository.all.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final AllEntityToDto mapper;

    @Autowired
    public ProfileService(ProfileRepository profileRepository, AllEntityToDto mapper){
        this.profileRepository = profileRepository;
        this.mapper = mapper;
    }

    public ProfileData getProfileData(UserIdRequest request){

        ProfileEntity entity = profileRepository.getUserProfile(request.getUserId());
        if( entity != null){
            return mapper.profileMapper(entity);
        }else{
            return null;
        }
    }
    public boolean updateProfileData(AllUpdateUserRequest request){
        return profileRepository.updateUserProfile(request.getUserId(), request.getFullName(), request.getEmail(),request.getRole(), request.getStatus(), request.getPhoneNumber(), request.getAddress());
    }
}
