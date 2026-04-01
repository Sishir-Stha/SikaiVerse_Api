package com.sikaiverse.backend.chatbot.controller;

import com.sikaiverse.backend.common.constants.ApiConstants;
import com.sikaiverse.backend.common.constants.HttpConstants;
import com.sikaiverse.backend.common.constants.StatusConstants;
import com.sikaiverse.backend.common.utils.ErrorMessage;
import com.sikaiverse.backend.chatbot.dto.request.ChatBotRequest;
import com.sikaiverse.backend.chatbot.dto.response.ChatBotResponse;
import com.sikaiverse.backend.chatbot.service.ChatBotService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(ApiConstants.AI_BASE)
@Slf4j
public class ChatBotController {

    private final ChatBotService chatBotService;

    @Autowired
    public ChatBotController(ChatBotService chatBotService) {
        this.chatBotService = chatBotService;
    }

    @PostMapping("/ask")
    public ResponseEntity<?> ask(@RequestBody ChatBotRequest request) {
        try {
            log.info("Received request: {}", request.getPrompt());

            // Call service to get courses
            List<Map<String, Object>> courses = chatBotService.getCourses(
                    request.getPrompt(), false // useLLM = false for /recommend
            );

            if (!courses.isEmpty()) {
                return ResponseEntity.ok(new ChatBotResponse(
                        StatusConstants.SUCCESS, courses
                ));
            } else {
                log.warn("No courses found for query: {}", request.getPrompt());
                return ResponseEntity.status(HttpConstants.FAILED)
                        .body(new ErrorMessage(
                                StatusConstants.FAILURE, "No courses found"
                        ));
            }

        } catch (Exception e) {
            log.error("Error calling /recommend: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR)
                    .body(new ErrorMessage(
                            StatusConstants.FAILURE, "AI Server Error: " + e.getMessage()
                    ));
        }
    }
}