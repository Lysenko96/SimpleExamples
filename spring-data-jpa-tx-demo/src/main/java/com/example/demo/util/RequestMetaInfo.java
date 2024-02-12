package com.example.demo.util;

public class RequestMetaInfo {
    private static ThreadLocal<String> ipContainer = new ThreadLocal<>();

    public static void setIp(String ip){
        ipContainer.set(ip);
    }

    public static String getCurrentIp(){
       return ipContainer.get();
    }
}
