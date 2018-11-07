package sch.hunnu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import sch.hunnu.utils.WebSocketHandle;


/**
 * 将自定义的websocket 服务器配置 进行注册
 */
@Configuration
@EnableWebSocket
public class WebSocketRegister implements WebSocketConfigurer {

    @Bean
    public WebSocketHandle build(){
        return new WebSocketHandle();
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(build(),"/index33");

    }
}
