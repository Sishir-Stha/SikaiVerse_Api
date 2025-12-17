package com.sikaiverse.backend.authentication.mapper;

import com.sikaiverse.backend.authentication.dto.response.LoginDataResponse;
import org.springframework.stereotype.Component;

@Component
public class DataMapper {

    public LoginDataResponse responseMapper(String token,String fullName,String role){
        LoginDataResponse response = new LoginDataResponse();
        response.setToken(token);
        response.setUsername(fullName);
        response.setRole(role);
        return  response;
    }

}
