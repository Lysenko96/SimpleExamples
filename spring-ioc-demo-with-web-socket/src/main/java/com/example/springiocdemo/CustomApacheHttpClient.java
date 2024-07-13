package com.example.springiocdemo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class CustomApacheHttpClient {

    public static void main(String[] args) throws IOException {

        HttpGet request = new HttpGet("https://google.com");

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(request)) {

            // Get HttpResponse Status
            System.out.println(response.getProtocolVersion());              // HTTP/1.1
            System.out.println(response.getStatusLine().getStatusCode());   // 200
            System.out.println(response.getStatusLine().getReasonPhrase()); // OK
            System.out.println(response.getStatusLine().toString());        // HTTP/1.1 200 OK

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }

        }
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost("https://reqres.in/api/users");
//            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            String json = """
                    {
                        "name": "anton",
                        "job": "lazy"
                    }""";
//            builder.addTextBody("json", json, ContentType.APPLICATION_JSON);
//            HttpEntity multipart = builder.build();
            httpPost.setHeader("content-type", "application/json");
            httpPost.setEntity(new StringEntity(json));
            CloseableHttpResponse response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            System.out.println(statusCode);
            InputStream is = response.getEntity().getContent();
            Scanner in = new Scanner(is);
            while (in.hasNextLine()) {
                System.out.println(in.nextLine());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
