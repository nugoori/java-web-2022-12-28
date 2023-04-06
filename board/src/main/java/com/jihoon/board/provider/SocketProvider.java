package com.jihoon.board.provider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
class SocketGroup {
    private String room;
    private WebSocketSession webSocketSession;
}
@Component
public class SocketProvider extends TextWebSocketHandler {
    
    private List<SocketGroup> sessionList = new ArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) {
        System.out.println("Socket Connected!!");
        System.out.println(webSocketSession.getHandshakeHeaders().getFirst("room"));
        
        String room = webSocketSession.getHandshakeHeaders().getFirst("room");
        sessionList.add(new SocketGroup(room, webSocketSession));
    }

    @Override
    protected void handleTextMessage(WebSocketSession webSocketSession, TextMessage textMessage) throws Exception {
        String messagePayload = textMessage.getPayload();
        String room = webSocketSession.getHandshakeHeaders().getFirst("room");

        for (SocketGroup socketGroup: sessionList) {
            if (socketGroup.getRoom().equals(room))
                socketGroup.getWebSocketSession().sendMessage(textMessage);
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) {
        System.out.println("Socket Closed!");
        System.out.println(webSocketSession.toString());
        System.out.println(closeStatus.toString());
        
        for (SocketGroup socketGroup: sessionList) {
            if (socketGroup.getWebSocketSession().equals(webSocketSession)) {
                sessionList.remove(socketGroup);
            }
        }
        
    }

}
