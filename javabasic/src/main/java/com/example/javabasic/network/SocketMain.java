package com.example.javabasic.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SocketMain {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        try (ServerSocket serverSocket = new ServerSocket(8081)) {
            while (true) {
                executorService.execute(() -> {
                    try (Socket client = serverSocket.accept()) {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                        System.out.println(reader.lines().collect(Collectors.joining(" ")));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
