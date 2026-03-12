package com.sikaiverse.backend.ollama.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OllamaRequest {
    @NotBlank(message = "Prompt is required")
    private String prompt;

    public OllamaRequest (String prompt){
        this.prompt = prompt;
    }
}
