package com.developbetter.demo.service;

import com.developbetter.demo.client.OllamaClient;
import org.springframework.stereotype.Service;

@Service
public class OllamaChatService {

    private final OllamaClient ollamaClient;

    public OllamaChatService(OllamaClient ollamaClient) {
        this.ollamaClient = ollamaClient;
    }

    public String chat(String message) {
        return ollamaClient.chat(message);
    }

}
