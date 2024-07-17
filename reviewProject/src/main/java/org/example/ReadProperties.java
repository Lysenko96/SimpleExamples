package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ReadProperties {

    public static void main(String[] args) {
        Properties p;

        {
            p = new Properties();
            try {
                p.load(Files.newInputStream(Paths.get("/home/user/Documents/reviewProject/src/main/resources/package.json")));
//                p.load(Files.newInputStream(Paths.get("/home/user/Documents/reviewProject/src/main/resources/build.properties")));
//                p.loadFromXML(Files.newInputStream(Paths.get("/home/user/Documents/reviewProject/src/main/resources/build1.xml")));
                p.list(System.out);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
