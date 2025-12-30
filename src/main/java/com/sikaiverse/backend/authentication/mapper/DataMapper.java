package com.sikaiverse.backend.authentication.mapper;

import com.sikaiverse.backend.authentication.dto.response.LoginDataResponse;
import org.springframework.stereotype.Component;

@Component
public class DataMapper {

    public LoginDataResponse responseMapper(long userId,String token,String fullName,String role){
        LoginDataResponse response = new LoginDataResponse();
        response.setUserId(userId);
        response.setToken(token);
        response.setUsername(fullName);
        response.setRole(role);
        return  response;
    }

}
