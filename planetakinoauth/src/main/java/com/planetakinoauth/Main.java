package com.planetakinoauth;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;

public class Main {


//    private static final String url = "https://api-integration.dev.planeta8.net/api/v1.0/customer?page=1&perPage=25&sortOrder=desc&sortBy=createdAt";
    private static final String url = "api/v1.0/customer?page=1&perPage=25&sortOrder=desc&sortBy=createdAt";
// openssl rsa -in private_key.pem -pubout -out public_key.pem // generate public key
    private final static String PRIVATE_KEY =
//    "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDMCU3yYMbUnmyX+Lm78mKumg4fS/guL31RYEMWc41FjeetCj9fLSUg/NV0IHGaCNKG4XyVjYoYl3Erg3yxLAHuOY7HWswTfiErcBo05jIFhDUwezKyBDFqMKR8YZGkZ2t7yf1QylhwBp9Z5xSok2Zypv60W2TDCESfnSHNNovi6bQwcm9oaFD/lkfZNLUWaQpTkJlevNUfF62yA7wgOZHrypzC8FQb3PYS312p3qqhwSOXwbGVi7QTfYN98lGgJUsCp2ox27h9ttRAFXVMS3ffoX6aupdZMJ9qz3QfOvy75j6/PLuT6MJgCalWbeYHHoDQn6+aDmKxNR5HKB2XHaghAgMBAAECggEAAlkcx1DyOx+/VOZmPV9ohFLi1Nzx4gR45M3scN6h/e6Rf6Bf6+ZEmsMU+zaAqC9dqgVJS/i8quZ/RUaR5AGDSizFQYUSoAXyN1kdkKokGM0nxh6zsnCffBpwNHKGuDNINE8jtfOqwnRtoJ2YrsRAo6VJWK66AVjf8LqXa349bFCTYNTGG/K7udwliCqLeHWC8C2p/KAryjRE2k5zimulyy9IC9tNSQNvyZMXaWNkw7swTeu1tZttTobha2x4MqxHxX+KGcHA78vveaCYRc7oBVTDd7Cli4dZiCQIHkLu9f9/bbbq04dYumDSGaZBLW6y9xh+wvmY4DsWOPvdNNDBGQKBgQDqdGTHDGnhAOPkQjcB75ncouNZFt7e6oCwEifk1SzfeOKNHSXPpjPgZ0EUqtbpb1pUist4kp7ePgGZ3uKEg1MCoZOnMq3hhCR07RgGhoQ3NCUyhgidxiWFOxuiAYfd7O6UjWZmDjn65u9DiAUc1e6TphZZYgWEWm66TtTOFsgx5QKBgQDeyU/j5tkv3DcwmA5Vcceyjzubx2nVfj/iZXJtp2gTUJ+KG/y0TwMHBdNWVnM6ZwEXEZyqwc5XJYyccbBhll4YvaKNxqpkVCtQE8Kf7N9vI55bTExPSu1CwECL0/pr23F4kQBot9W53kKBespCi9Tl48FdxOVaJHSg/objI6KpjQKBgQDDuMLgf/ZrhUi5pqUxEopJbBmKp9MKGI2xbparK2K4c7v8vZZxEHhCHzBvRmb+nJy18uAFGbFSKkU/5JcItHC5w5T1gRMzLhMZIUxrNiRtyTQ8RzQuMdnkrQFWbxyzITXSAXC4RawVTm/y2jwaZGU0EPSbTX75jFzfXyu7l70sGQKBgQDeici7pgScwiR+7eSjhRwtSNYKLY+SKqI1y5AZ6HcVlBtJIduzYJltkmwgegpv9CQqnvUXvLAYbPGf9BBz6nfjzslpRWE/BrSdMJ/gkARASBwOppAzRGzrmI7hHcWvp2wZOv5lm/xpxZI5NCaFgpgPawnkWKGhAXlet+CVUytQoQKBgQDkiTaxCtqOgDv9EgWZF2gHw2iv3VCCUBwZNs2Qc4N+zvHqE8x/S7X7qPuNFuzrHD6f3oSqKdB1Ce//F9cCOs5ah2Iwj2nx9XqRlF8lfjOSd7f9n/vBk42YNeOfq1yhn1IAxwJrCgD4W/NG2G3qgKTZZTBdpLMnxRr3l320uqBAxg==";
    "MIICXAIBADCCAjUGByqGSM44BAEwggIoAoIBAQCPeTXZuarpv6vtiHrPSVG28y7FnjuvNxjo6sSWHz79NgbnQ1GpxBgzObgJ58KuHFObp0dbhdARrbi0eYd1SYRpXKwOjxSzNggooi/6JxEKPWKpk0U0CaD+aWxGWPhL3SCBnDcJoBBXsZWtzQAjPbpUhLYpH51kjviDRIZ3l5zsBLQ0pqwudemYXeI9sCkvwRGMn/qdgYHnM423krcw17njSVkvaAmYchU5Feo9a4tGU8YzRY+AOzKkwuDycpAlbk4/ijsIOKHEUOThjBopo33fXqFD3ktm/wSQPtXPFiPhWNSHxgjpfyEc2B3KI8tuOAdl+CLjQr5ITAV2OTlgHNZnAh0AuvaWpoV499/e5/pnyXfHhe8ysjO65YDAvNVpXQKCAQAWplxYIEhQcE51AqOXVwQNNNo6NHjBVNTkpcAtJC7gT5bmHkvQkEq9rI837rHgnzGC0jyQQ8tkL4gAQWDt+coJsyB2p5wypifyRz6Rh5uixOdEvSCBVEy1W4AsNo0fqD7UielOD6BojjJCilx4xHjGjQUntxyaOrsLC+EsRGiWOefTznTbEBplqiuH9kxoJts+xy9LVZmDS7TtsC98kOmkltOlXVNb6/xF1PYZ9j897buHOSXC8iTgdzEpbaiH7B5HSPh++1/et1SEMWsiMt7lU92vAhErDR8C2jCXMiT+J67ai51LKSLZuovjntnhA6Y8UoELxoi34u1DFuHvF9veBB4CHAOPK1cxwllHTk+5oSDr7QfP/j8W8W9RCMoutbs=";
    private final static String PUBLIC_KEY =
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzAlN8mDG1J5sl/i5u/JirpoOH0v4Li99UWBDFnONRY3nrQo/Xy0lIPzVdCBxmgjShuF8lY2KGJdxK4N8sSwB7jmOx1rME34hK3AaNOYyBYQ1MHsysgQxajCkfGGRpGdre8n9UMpYcAafWecUqJNmcqb+tFtkwwhEn50hzTaL4um0MHJvaGhQ/5ZH2TS1FmkKU5CZXrzVHxetsgO8IDmR68qcwvBUG9z2Et9dqd6qocEjl8GxlYu0E32DffJRoCVLAqdqMdu4fbbUQBV1TEt336F+mrqXWTCfas90Hzr8u+Y+vzy7k+jCYAmpVm3mBx6A0J+vmg5isTUeRygdlx2oIQIDAQAB";
    public static void main(String[] args) {
        Main main = new Main();
//        String res = main.calculateHash(PUBLIC_KEY, "MD5");
//        System.out.println(res);
//        String res1 = main.calculateHash(url, "SHA-256");
//        String base64Sign = Base64.getEncoder().encodeToString(res1.getBytes());
//        System.out.println(base64Sign);
//        String res1 = main.calculateHash(url, "SHA-256");
        main.sign(url);
        KeyPairGenerator keyPairGen = null;
        try {
            keyPairGen = KeyPairGenerator.getInstance("DSA");
            keyPairGen.initialize(2048);  // DSA key size (2048-bit)
            KeyPair keyPair = keyPairGen.generateKeyPair();
//            System.out.println(Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        PrivateKey privateKey;
        try {
            byte[] privateBytes = Base64.getDecoder().decode(PRIVATE_KEY);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("DSA");
            privateKey = keyFactory.generatePrivate(keySpec);
            String result = signData(url, privateKey);
            System.out.println(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static String signData(String data, PrivateKey privateKey) throws Exception {
        Signature sign = Signature.getInstance("SHA256withDSA");
        sign.initSign(privateKey);
        sign.update(data.getBytes());
        byte[] signature = sign.sign();
        return Base64.getEncoder().encodeToString(signature);
    }

    private String sign(String url) {
        try {
            Signature signature = Signature.getInstance("SHA256withRSA");
            PrivateKey privateKey = generatePrivateKey();
            signature.initSign(privateKey);
            signature.update(url.getBytes());

            byte[] signed = signature.sign();

            String base64Sign = Base64.getEncoder().encodeToString(signed);
            System.out.println(base64Sign);

            Signature signatureVerify = Signature.getInstance("SHA256withRSA");
            PublicKey publicKey = generatePublicKey();
            signatureVerify.initVerify(publicKey);
            signatureVerify.update(url.getBytes());
            boolean verify = signatureVerify.verify(Base64.getDecoder().decode(base64Sign));
            System.out.println(verify);

            return base64Sign;
        } catch (NoSuchAlgorithmException | SignatureException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    private PublicKey generatePublicKey() {
        PublicKey pubKey;
        try {
            String publicKeyStr = PUBLIC_KEY;
            byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyStr);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            pubKey = keyFactory.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
        return pubKey;
    }

    private PrivateKey generatePrivateKey() {
        PrivateKey privateKey;
        try {
            byte[] privateBytes = Base64.getDecoder().decode(PRIVATE_KEY);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            privateKey = keyFactory.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
        return privateKey;
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
