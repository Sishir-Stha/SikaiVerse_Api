package com.sikaiverse.backend.common.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessage {
    private int status ;
    private String message;
}
