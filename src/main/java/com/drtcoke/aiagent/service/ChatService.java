package com.drtcoke.aiagent.service;

import com.drtcoke.aiagent.config.ChatProperties;
import com.drtcoke.aiagent.dto.ChatResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatClient chatClient;
    private final ChatProperties chatProperties;

    public ChatService(ChatClient.Builder chatClientBuilder, ChatProperties chatProperties) {
        this.chatClient = chatClientBuilder.build();
        this.chatProperties = chatProperties;
    }

    public ChatResponse chat(String message) {
        if (chatProperties.mock()) {
            return new ChatResponse("mock", "[mock] 收到消息: " + message);
        }

        String reply = chatClient.prompt(message)
                .call()
                .content();
        return new ChatResponse("openai", reply);
    }
}
