package com.sikaiverse.backend.admin.dto.response.user;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdminUserData {

    private Integer userId;
    private String fullName;
    private String email;
    private String role;
    private String status;
    private String phoneNumber;
    private String address;
    private LocalDateTime joinedDate;

}
