package com.sikaiverse.backend.chatbot.dto.response;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ChatBotResponse {

    private String success;
    private List<Map<String, Object>> courses;

    public ChatBotResponse(String success, List<Map<String, Object>> courses) {
        this.success = success;
        this.courses = courses;
    }
}