package com.example.javabasic.network.http;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class HttpMain {

    public static void main(String[] args) {

        try {
            URL url = new URI("https://upload.wikimedia.org/wikipedia/commons/9/9d/Smaky_100_IMG_4149.jpg").toURL();
            BufferedImage image = ImageIO.read(url);
            System.out.println(image);
            System.out.println(image.getHeight());
            System.out.println(image.getWidth());
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
