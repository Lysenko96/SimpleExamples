package info.lysenko.anton.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            ServerSocket serverSocket = new ServerSocket(4242);
            Socket sock = serverSocket.accept();
            while (true){
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                writer.println(in.nextLine());
                writer.flush();
                InputStreamReader stream = new InputStreamReader(sock.getInputStream());
                BufferedReader reader = new BufferedReader(stream);
                writer = new PrintWriter(sock.getOutputStream());
                String line = reader.readLine();
                System.out.println(line);
                writer.flush();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}