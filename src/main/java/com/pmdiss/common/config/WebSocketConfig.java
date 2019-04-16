package com.pmdiss.common.config;

import com.ajy.core.common.websocket.MessagePushTextHandler;
import com.ajy.core.common.websocket.TokenHandshakeInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.HandshakeInterceptor;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(messagePushHandler(),"/msg/push")
                .setAllowedOrigins("*")
                .addInterceptors(tokenHandshakeInterceptor());
    }

    @Bean
    public WebSocketHandler messagePushHandler(){
        return new MessagePushTextHandler();
    }

    @Bean
    public HandshakeInterceptor tokenHandshakeInterceptor(){
        return new TokenHandshakeInterceptor();
    }

    @Bean
    public MessagePushTextHandler initMessagePushTextHandler(){
        return new MessagePushTextHandler();
    }
}
