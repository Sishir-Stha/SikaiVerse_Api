package com.sikaiverse.backend.shared.dto.response.all;

import lombok.Data;

@Data
public class ProfileData {

    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;
    private String role;

}
