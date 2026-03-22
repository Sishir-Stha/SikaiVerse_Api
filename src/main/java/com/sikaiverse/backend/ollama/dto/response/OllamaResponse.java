package com.sikaiverse.backend.ollama.dto.response;


import lombok.Data;

@Data
public class OllamaResponse {

    private String success;
    private String response;

    public OllamaResponse(String success, String response){
        this.success = success;
        this.response = response;
    }
}
