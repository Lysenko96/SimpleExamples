package info.lysenko.anton.readfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {

        try {
            File file = new File("/home/user/Desktop/todo/09.22/new_file");
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
