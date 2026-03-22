package com.sikaiverse.backend.ollama.service;

import com.sikaiverse.backend.ollama.dto.response.AIResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class OllamaService {

    private final RestTemplate restTemplate;
    private String baseUrl = "http://localhost:11434";
    private String model = "course-ai";

    // Constructor with timeout settings
    public OllamaService() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(10000);   // 10 seconds to connect
        factory.setReadTimeout(120000);     // 120 seconds to wait for response
        this.restTemplate = new RestTemplate(factory);
    }

    public String ask(String message) {
        String requestUrl = baseUrl + "/api/generate";

        String prompt = "<|user|>\n" + message + "\n<|assistant|>\n";

        log.info("Sending prompt to Ollama: {}", prompt);

        Map<String, Object> body = new HashMap<>();
        body.put("model", model);
        body.put("prompt", prompt);
        body.put("stream", false);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        try {
            log.info("Calling Ollama API... (this may take a moment)");

            ResponseEntity<AIResponse> response = restTemplate.postForEntity(
                    requestUrl, request, AIResponse.class
            );

            log.info("Ollama response status: {}", response.getStatusCode());
            log.info("Ollama response body: {}", response.getBody());

            if (response.getBody() != null && response.getBody().getResponse() != null) {
                String answer = response.getBody().getResponse();
                log.info("AI Answer: {}", answer);
                return answer;
            } else {
                log.error("Ollama returned null response");
                return "No response from AI";
            }

        } catch (Exception e) {
            log.error("Error calling Ollama: {}", e.getMessage());
            return "Error: " + e.getMessage();
        }
    }
}