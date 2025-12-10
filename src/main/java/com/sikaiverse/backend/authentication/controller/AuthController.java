package com.sikaiverse.backend.authentication.controller;

import com.sikaiverse.backend.authentication.dto.request.LoginRequest;
import com.sikaiverse.backend.authentication.dto.request.SignUpRequest;
import com.sikaiverse.backend.authentication.dto.response.LoginResponse;
import com.sikaiverse.backend.authentication.entity.AuthUserEntity;
import com.sikaiverse.backend.authentication.service.AuthService;
import com.sikaiverse.backend.common.constants.ApiConstants;
import com.sikaiverse.backend.common.constants.HttpConstants;
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

@Autowired
private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login (@Valid @RequestBody LoginRequest request){
        try {
            AuthUserEntity reponse = authService.login(request.getEmail(), request.getPassword());
            if (reponse != null){
                log.info("<<Auth logging Request recieved>>");
                String token = JwtTokenUtil.generateToken(reponse.getEmail());
                return ResponseEntity.ok(new LoginResponse(200,token, reponse.getFullName(), reponse.getRole()));
            }else{
                log.debug("User is null ( Invalid user or credentials )");
                return ResponseEntity.status(HttpConstants.INVALID_CREDENTIALS).body(new ErrorMessage(401,"Invalid Credentials"));
            }
        }catch (Exception e){
            log.error("Error occurred during login for user: {}", request.getEmail(), e);
            return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR).body(new ErrorMessage(500,"Server Error "));
        }
    }


    @PostMapping("/signup")
    public ResponseEntity<?> signup (@Valid @RequestBody SignUpRequest request){
        try {
            boolean reponse = authService.insertuser(request);
            if (reponse){
                log.info("<< " +request.getRole()+" Created Sucessfully>>");
                return ResponseEntity.ok(reponse);
            }else{
                log.debug("User is null ( Invalid user or credentials )");
                return ResponseEntity.status(HttpConstants.FAILED).body(new ErrorMessage(422,"Failed to create user"));
            }
        }catch (Exception e){
            log.error("Error occurred during login for user: {}", request.getEmail(), e);
            return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR).body(new ErrorMessage(500,"Server Error "));
        }
    }

}
