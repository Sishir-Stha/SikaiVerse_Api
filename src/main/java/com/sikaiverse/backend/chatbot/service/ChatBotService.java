package com.sikaiverse.backend.chatbot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ChatBotService {

    private final RestTemplate restTemplate;
    private String baseUrl = "http://localhost:8000";

    public ChatBotService() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(10000); // 10 seconds
        factory.setReadTimeout(120000);   // 2 minutes
        this.restTemplate = new RestTemplate(factory);
    }

    public Map<String, Object> recommend(String query, boolean useLLM) {
        String requestUrl = baseUrl + "/recommend";

        // Build request body
        Map<String, Object> body = new HashMap<>();
        body.put("query", query);
        body.put("use_llm", useLLM);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        try {
            log.info("Sending request to {} with query='{}', useLLM={}", requestUrl, query, useLLM);

            // Call API
            ResponseEntity<Map> response = restTemplate.postForEntity(requestUrl, request, Map.class);

            log.info("Response status: {}", response.getStatusCode());
            log.info("Response body: {}", response.getBody());

            if (response.getBody() != null) {
                return response.getBody();
            } else {
                log.error("No response body returned from /recommend");
                return Map.of("error", "No response from API");
            }

        } catch (Exception e) {
            log.error("Error calling /recommend: {}", e.getMessage(), e);
            return Map.of("error", e.getMessage());
        }
    }

    public List<Map<String, Object>> getCourses(String query, boolean useLLM) {
        Map<String, Object> response = recommend(query, useLLM);
        Object coursesObj = response.get("courses");

        if (coursesObj instanceof List) {
            return (List<Map<String, Object>>) coursesObj;
        } else {
            log.warn("No courses found in response");
            return List.of();
        }
    }
}