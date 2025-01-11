package com.planetakinoauth.rsa;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

    private static String PUBLIC_KEY = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzAlN8mDG1J5sl/i5u/Ji\n" +
            "rpoOH0v4Li99UWBDFnONRY3nrQo/Xy0lIPzVdCBxmgjShuF8lY2KGJdxK4N8sSwB\n" +
            "7jmOx1rME34hK3AaNOYyBYQ1MHsysgQxajCkfGGRpGdre8n9UMpYcAafWecUqJNm\n" +
            "cqb+tFtkwwhEn50hzTaL4um0MHJvaGhQ/5ZH2TS1FmkKU5CZXrzVHxetsgO8IDmR\n" +
            "68qcwvBUG9z2Et9dqd6qocEjl8GxlYu0E32DffJRoCVLAqdqMdu4fbbUQBV1TEt3\n" +
            "36F+mrqXWTCfas90Hzr8u+Y+vzy7k+jCYAmpVm3mBx6A0J+vmg5isTUeRygdlx2o\n" +
            "IQIDAQAB\n" +
            "-----END PUBLIC KEY-----\n";

    public static void main(String[] args) {
        Hash hash = new Hash();
        System.out.println(hash.calculateHash(PUBLIC_KEY, "MD5"));
    }


    private String calculateHash(String text, String algorithm) {
        StringBuilder hash = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            byte[] digest = md.digest(text.getBytes());
            for (byte b : digest) {
                hash.append(String.format("%02x", b));
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return hash.toString();
    }
}
