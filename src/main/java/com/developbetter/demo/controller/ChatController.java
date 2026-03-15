package com.developbetter.demo.controller;

import com.developbetter.demo.service.OllamaChatService;
import com.developbetter.demo.service.OpenAiChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final OpenAiChatService openAiChatService;
    private final OllamaChatService ollamaChatService;

    public ChatController(OpenAiChatService openAiChatService, OllamaChatService ollamaChatService) {
        this.openAiChatService = openAiChatService;
        this.ollamaChatService = ollamaChatService;
    }

    @GetMapping("/openai")
    public ResponseEntity<String> chatWithOpenAi(@RequestParam String message) {
        return ResponseEntity.ok(openAiChatService.chat(message));
    }

    @GetMapping("/ollama")
    public ResponseEntity<String> chatWithOllama(@RequestParam String message) {
        return ResponseEntity.ok(ollamaChatService.chat(message));
    }

}
