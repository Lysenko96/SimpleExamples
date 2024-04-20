package com.example.springiocdemo.websocket;

import org.glassfish.tyrus.client.ClientManager;
import org.glassfish.tyrus.core.AnnotatedEndpoint;

import javax.websocket.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

@ClientEndpoint
public class ChatClientEndpoint {

//    private static Session session;
    @OnOpen
    public void onOpen(Session session) {
//        ChatClientEndpoint.session = session;
        System.out.println ("--- Connected " + session.getId());
    }

//        @OnMessage
//    public String onMessage(String message, Session session) {
//        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
//        try {
//            System.out.println ("--- Received " + message);
//            String userInput = bufferRead.readLine();
//            return userInput;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
    @OnMessage
    public String onMessage(String msg) {
        System.out.println (msg);
        return msg;
    }


    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println("--- Session: " + session.getId());
        System.out.println("--- Closing because: " + closeReason);
    }

    public static void main(String[] args) {
        ClientManager client = ClientManager.createClient();
        try {
            URI uri = new URI("ws://localhost:8025/folder/app");
            ChatClientEndpoint chatClientEndpoint = new ChatClientEndpoint();
            Session session1 = client.connectToServer(chatClientEndpoint.getClass(), uri);
            Thread.sleep(1500L);
            CloseReason closeReason = new CloseReason(CloseReason.CloseCodes.NORMAL_CLOSURE, "NORMAL_CLOSURE");
//            chatClientEndpoint.onClose(session1, closeReason);
            for(int i = 0; i < 5; i ++) {
                session1.getBasicRemote().sendText("start");
                chatClientEndpoint.onMessage("start");
            }

            for(MessageHandler messageHandler : session1.getMessageHandlers()) {
                System.out.println(messageHandler);
            }

            session1.close();
//            while(true) {}
        } catch (DeploymentException | URISyntaxException e) {
            e.printStackTrace();
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
