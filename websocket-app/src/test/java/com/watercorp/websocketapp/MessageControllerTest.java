package com.watercorp.websocketapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageControllerTest {

    private static final String TOPIC_GREETINGS = "/topic/greetings";

    @MockBean
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private MessageController messageController;

    @Test
    public void shouldSendMessageToTopicGreetingsFromPostMappingPublish() {
        messageController.publish("Test message");

        verify(simpMessagingTemplate, times(1)).convertAndSend(eq(TOPIC_GREETINGS), anyString());
    }

}