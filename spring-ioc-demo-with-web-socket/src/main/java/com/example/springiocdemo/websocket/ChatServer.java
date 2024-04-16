package com.example.springiocdemo.websocket;

import org.glassfish.tyrus.server.Server;

public class ChatServer {
    public static void main (String[] args) {
        Server server;
        server = new Server ("localhost", 8025, "/folder", ChatServerEndpoint.class);
        try {
            server.start();
            System.out.println("--- server is running");
            while(true){}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            server.stop();
        }
    }
}
