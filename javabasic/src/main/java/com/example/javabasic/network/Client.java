package com.example.javabasic.network;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try (Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 8080)) {
//            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//            Scanner in = new Scanner(System.in);
//            while (in.hasNext()) {
//                String result = in.next();
//                if(result.equals("exit")) break;
//                writer.write(result + System.lineSeparator());
//            }
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            //writer.println("GET /startup?name=Ivan HTTP/1.1");
            writer.println("GET /startup HTTP/1.1");
            writer.println("Host: 127.0.0.1");
            writer.println("Cookie: JSESSIONID=BA40DC950DEA1A9D29F9508C64C8C254"); // if set JSESSIONID save name after send http with name
            writer.println();
            writer.flush();
            InputStream stream = socket.getInputStream();
            InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            bufferedReader.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
