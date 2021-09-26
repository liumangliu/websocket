package com.coding.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author liumang
 */
@Configuration
public class WebSocketConfiguration {

    @Bean
    public ServerEndpointExporter handlerAdapter() {
        return new ServerEndpointExporter();
    }
}
