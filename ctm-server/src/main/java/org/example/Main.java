package org.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;


import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
            System.out.println("########ADDRESS: " +server.getAddress());

            server.createContext("/test",exchange -> {
                byte[] text = "Hello".getBytes("UTF-8");
                exchange.sendResponseHeaders(200, text.length);
                System.out.println("########TEST");
                try (OutputStream os = exchange.getResponseBody()) { os.write(text); }
            });
            server.setExecutor(null);
            server.start();
            Thread.currentThread().join();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static class SimpleHandler implements HttpHandler {
        private final String response;

        public SimpleHandler(String response) {
            this.response = response;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            byte[] bytes = response.getBytes("UTF-8");
            exchange.sendResponseHeaders(200, bytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }
        }
    }
}