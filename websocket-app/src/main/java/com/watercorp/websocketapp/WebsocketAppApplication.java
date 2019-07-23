package com.watercorp.websocketapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootApplication
public class WebsocketAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebsocketAppApplication.class, args);
	}
}
