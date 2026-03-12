package com.sikaiverse.backend.ollama.controller;


import com.sikaiverse.backend.common.constants.ApiConstants;
import com.sikaiverse.backend.common.constants.HttpConstants;
import com.sikaiverse.backend.common.constants.StatusConstants;
import com.sikaiverse.backend.common.utils.ErrorMessage;
import com.sikaiverse.backend.ollama.dto.request.OllamaRequest;
import com.sikaiverse.backend.ollama.dto.response.OllamaResponse;
import com.sikaiverse.backend.ollama.service.OllamaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping(ApiConstants.AI_BASE)
@Slf4j
public class OllamaController {

    private final OllamaService ollamaService;


    @Autowired
    public OllamaController(OllamaService ollamaService) {
        this.ollamaService = ollamaService;
    }

    @PostMapping("/ask")
    public ResponseEntity<?> ask(@RequestBody OllamaRequest request) {
        try {
            log.info("Received request: {}", request.getPrompt());

            String answer = ollamaService.ask(request.getPrompt());

            log.info("Got answer: {}", answer);

            if (answer != null && !answer.isEmpty()) {
                return ResponseEntity.ok(new OllamaResponse(
                        StatusConstants.SUCCESS, answer
                ));
            } else {
                return ResponseEntity.status(HttpConstants.FAILED)
                        .body(new ErrorMessage(
                                StatusConstants.FAILURE, "Empty response from AI"
                        ));
            }
        } catch (Exception e) {
            log.error("Error: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpConstants.INTERNAL_SERVER_ERROR)
                    .body(new ErrorMessage(
                            StatusConstants.FAILURE, "AI Server Error: " + e.getMessage()
                    ));
        }
    }
}