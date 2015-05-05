package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created by rodrigo on 11/04/15.
 */
@Configuration
@EnableWebSocket
public class WebConfiguration implements WebSocketConfigurer {

    @Autowired
    private MyWebSocketHandler handler;


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

        System.out.println("----------------- registro realizado");
        registry.addHandler(handler,"/eco/{topico}");
    }
}
