package info.lysenko.anton.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 4242);
            InputStreamReader stream = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(stream);
            Scanner in = new Scanner(System.in);
            while (true) {
                PrintWriter writer = new PrintWriter(socket.getOutputStream());
                String line = reader.readLine();
                writer.println(in.nextLine());
                System.out.println(line);
                writer.flush();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
