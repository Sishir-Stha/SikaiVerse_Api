package com.sikaiverse.backend.shared.service.all;

import com.sikaiverse.backend.shared.dto.response.all.ProfileData;
import com.sikaiverse.backend.shared.repository.all.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
    }

    public ProfileData getProfileData(){

    }
}
