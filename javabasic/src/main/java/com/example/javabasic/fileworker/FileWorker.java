package com.example.javabasic.fileworker;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Scanner;

public class FileWorker {

    private static String PATH = "/src/main/resources/file";

    public static void main(String[] args) throws URISyntaxException {

        Scanner input = new Scanner(System.in);
        String projectPath = System.getProperty("user.dir");
        while (true) {
            System.out.println("read file - 1 ");
            System.out.println("write file - 2 (enter exit break)");
            System.out.print("enter: ");
            String command = input.next();
            if(command.equalsIgnoreCase("exit")) break;
            switch (command) {
                case ("1"):
                    try (BufferedReader reader = new BufferedReader(new FileReader(projectPath + PATH))) {
                        while (reader.ready()) {
                            System.out.println(reader.readLine());
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case ("2"): {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(projectPath + PATH, true))) {
                        while (input.hasNextLine()) {
                            String line = input.nextLine();
                            if (line.equalsIgnoreCase("exit")) break;
                            writer.write(line);
                        }
                        writer.write(System.lineSeparator());
                        writer.flush();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                    break;
            }
        }
        input.close();
    }
}
