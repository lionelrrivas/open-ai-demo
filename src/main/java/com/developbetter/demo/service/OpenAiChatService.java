package com.developbetter.demo.service;

import com.developbetter.demo.client.OpenAiClient;
import org.springframework.stereotype.Service;

@Service
public class OpenAiChatService {

    private final OpenAiClient openAiClient;

    public OpenAiChatService(OpenAiClient openAiChatClient) {
        this.openAiClient = openAiChatClient;
    }

    public String chat(String message) {
        return openAiClient.chat(message);
    }

}
