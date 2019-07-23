package com.watercorp.websocketapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private static final String TOPIC_GREETINGS = "/topic/greetings";

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    // Use this method for receive stompjs message form method stompClient.send
    @MessageMapping("/message")
    @SendTo("/topic/greetings")
    public String send(String message) {
        return message;
    }

    // Use this method for receive http post and publish same to topic/greetings
    @PostMapping("publish")
    public void publish(@RequestBody String message) {
        simpMessagingTemplate.convertAndSend(TOPIC_GREETINGS, message);
    }

}
