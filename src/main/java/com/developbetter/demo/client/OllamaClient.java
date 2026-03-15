package com.developbetter.demo.client;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;

@Component
public class OllamaClient {

    private final ChatClient chatClient;

    public OllamaClient(ChatClient ollamaChatClient) {
        this.chatClient = ollamaChatClient;
    }

    public String chat(String message) {
        return chatClient.prompt(message).call().content();
    }
}
