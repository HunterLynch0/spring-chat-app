package com.chat.app.controller;

import com.chat.app.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @MessageMapping("/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage message) {
        return message;
    }

    // serve it at the root URL
    @GetMapping("/")
    public String home() {
        return "forward:/chat.html";   // file is in static/
    }

    // optional: also serve at /chat
    @GetMapping("/chat")
    public String chat() {
        return "forward:/chat.html";   // note the leading slash + .html
    }
}
