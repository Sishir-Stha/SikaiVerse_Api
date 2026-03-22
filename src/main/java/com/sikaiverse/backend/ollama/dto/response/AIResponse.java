package com.sikaiverse.backend.ollama.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class AIResponse {

    private String model;
    private String response;
    private boolean done;
}
