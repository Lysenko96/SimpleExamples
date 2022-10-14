package info.lysenko.anton.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Calendar c = Calendar.getInstance();
//        Date date1 = c.getTime();
//        System.out.println(date1);
//        c.add(Calendar.DAY_OF_WEEK, 7);
//        Date date2 = c.getTime();
//        System.out.println(date2);
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        System.out.println(format.format(new Date().getTime() - 86400000));
//        System.out.println(format.format(new Date().getTime()));
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