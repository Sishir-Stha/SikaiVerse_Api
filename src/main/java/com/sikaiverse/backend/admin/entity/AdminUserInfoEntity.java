package com.sikaiverse.backend.admin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class AdminUserInfoEntity {

    @Id
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "fullname", nullable = false)
    private String fullName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "joined_date", nullable = false)
    private LocalDateTime joinedDate;

}
