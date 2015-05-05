package hello;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by rodrigo on 11/04/15.
 */
@Component
public class MyWebSocketHandler implements WebSocketHandler {

    private List<WebSocketSession> sessions = new ArrayList<WebSocketSession>();

    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {

        sessions.add(webSocketSession);
        System.out.println("sessao iniciada "+webSocketSession.getId()+" URI "+webSocketSession.getUri().getPath());

    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {

        System.out.println(webSocketMessage.getPayload().toString());

        for(WebSocketSession session:sessions)
            session.sendMessage(webSocketMessage);

    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {

    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
