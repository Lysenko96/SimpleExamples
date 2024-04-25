package com.example.springiocdemo.websocket;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/app")
public class ChatServerEndpoint {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println ("--- Connected: " + session.getId());
    }

    @OnMessage
    public String onMessage(String message, Session session) {
        System.out.println("--- Message: " + message);
        return message;
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println("--- Session: " + session.getId());
        System.out.println("--- Closing because: " + closeReason);
    }

}
