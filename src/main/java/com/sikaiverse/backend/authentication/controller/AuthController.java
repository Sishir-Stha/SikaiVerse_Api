package com.sikaiverse.backend.authentication.controller;

import com.sikaiverse.backend.authentication.dto.request.LoginRequest;
import com.sikaiverse.backend.authentication.dto.request.SignUpRequest;
import com.sikaiverse.backend.authentication.dto.response.LoginDataResponse;
import com.sikaiverse.backend.authentication.dto.response.LoginResponse;
import com.sikaiverse.backend.authentication.entity.AuthUserEntity;
import com.sikaiverse.backend.authentication.mapper.DataMapper;
import com.sikaiverse.backend.authentication.service.AuthService;
import com.sikaiverse.backend.common.constants.ApiConstants;
import com.sikaiverse.backend.common.constants.HttpConstants;
import com.sikaiverse.backend.common.constants.StatusConstants;
import com.sikaiverse.backend.common.security.JwtTokenUtil;
import com.sikaiverse.backend.common.utils.ErrorMessage;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(ApiConstants.AUTH_BASE)
public class AuthController {

private final AuthService authService;
private final DataMapper dataMapper;

@Autowired
public AuthController(AuthService authService, DataMapper dataMapper){
    this.authService = authService;
    this.dataMapper = dataMapper;
}

    @PostMapping("/login")
    public ResponseEntity<?> login (@Valid @RequestBody LoginRequest request){
        try {
            AuthUserEntity response = authService.login(request.getEmail(), request.getPassword());
            if (response != null){
                log.info("<<Auth logging Request recieved>>");
                String token = JwtTokenUtil.generateToken(response.getEmail());
                LoginDataResponse data = dataMapper.responseMapper(token,response.getFullName(),response.getPassword());
                return ResponseEntity.ok(new LoginResponse(StatusConstants.SUCCESS, data));
            }else{
                log.debug("User is null ( Invalid user or credentials )");
                return ResponseEntity.status(HttpConstants.INVALID_CREDENTIALS).body(new ErrorMessage(StatusConstants.FAILURE,"Invalid Credentials"));
            }
        }catch (Exception e){
            log.error("Error occurred during login for user: {}", request.getEmail(), e);
            return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR).body(new ErrorMessage(StatusConstants.FAILURE,"Server Error "));
        }
    }


    @PostMapping("/signup")
    public ResponseEntity<?> signup (@Valid @RequestBody SignUpRequest request){
        try {
            boolean created = authService.insertuser(request);
            if (created){
                log.info("<< " +request.getRole()+" Created Sucessfully>>");
                String response = "success : "+created;
                return ResponseEntity.ok(response);
            }else{
                log.debug("User is null ( Invalid user or credentials )");
                return ResponseEntity.status(HttpConstants.FAILED).body(new ErrorMessage(StatusConstants.FAILURE,"Failed to create user"));
            }
        }catch (Exception e){
            log.error("Error occurred during login for user: {}", request.getEmail(), e);
            return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR).body(new ErrorMessage(StatusConstants.FAILURE,"Server Error "));
        }
    }

}
