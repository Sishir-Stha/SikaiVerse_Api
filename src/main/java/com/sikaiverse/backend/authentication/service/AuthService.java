package com.sikaiverse.backend.authentication.service;

import com.sikaiverse.backend.authentication.dto.request.SignUpRequest;
import com.sikaiverse.backend.authentication.entity.AuthUserEntity;
import com.sikaiverse.backend.authentication.repository.AuthRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;


    public AuthUserEntity login(String email, String password){
            AuthUserEntity user = authRepository.login(email,password);
            if(user!= null){
                return user;
            }else {
                return null;
            }
    }


    public boolean insertuser(SignUpRequest request){
            Boolean inserted = authRepository.insertuser(request.getFullName(),request.getEmail(), request.getPassword(), request.getRole());
            return inserted;
    }


}
