package com.sikaiverse.backend.chatbot.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ChatBotRequest {
    @NotBlank(message = "Prompt is required")
    private String prompt;

    public ChatBotRequest(String prompt){
        this.prompt = prompt;
    }
}
