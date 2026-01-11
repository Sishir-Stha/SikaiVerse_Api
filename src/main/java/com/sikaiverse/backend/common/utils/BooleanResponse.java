package com.sikaiverse.backend.common.utils;

import lombok.Data;

@Data
public class BooleanResponse {
    private String success;

    public BooleanResponse(String success){
        this.success = success;
    }
}
