package com.developbetter.demo.client;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Component;

@Component
public class OpenAiClient {

    private final ChatClient chatClient;

    public OpenAiClient(ChatClient openAiChatClient) {
        this.chatClient = openAiChatClient;
    }

    public String chat(String message) {
        return chatClient.prompt(message).call().content();
    }
}
