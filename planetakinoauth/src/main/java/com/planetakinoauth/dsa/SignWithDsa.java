package com.planetakinoauth.dsa;

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class SignWithDsa {
    //    private static final String url = "https://api-integration.dev.planeta8.net/api/v1.0/customer?page=1&perPage=25&sortOrder=desc&sortBy=createdAt";
    private static final String url = "api/v1.0/customer?page=1&perPage=25&sortOrder=desc&sortBy=createdAt";
    // openssl dsa -in dsa_private.pem -pubout -out dsa_public.pem
    private final static String PRIVATE_KEY = "MIICXAIBADCCAjUGByqGSM44BAEwggIoAoIBAQCPeTXZuarpv6vtiHrPSVG28y7FnjuvNxjo6sSWHz79NgbnQ1GpxBgzObgJ58KuHFObp0dbhdARrbi0eYd1SYRpXKwOjxSzNggooi/6JxEKPWKpk0U0CaD+aWxGWPhL3SCBnDcJoBBXsZWtzQAjPbpUhLYpH51kjviDRIZ3l5zsBLQ0pqwudemYXeI9sCkvwRGMn/qdgYHnM423krcw17njSVkvaAmYchU5Feo9a4tGU8YzRY+AOzKkwuDycpAlbk4/ijsIOKHEUOThjBopo33fXqFD3ktm/wSQPtXPFiPhWNSHxgjpfyEc2B3KI8tuOAdl+CLjQr5ITAV2OTlgHNZnAh0AuvaWpoV499/e5/pnyXfHhe8ysjO65YDAvNVpXQKCAQAWplxYIEhQcE51AqOXVwQNNNo6NHjBVNTkpcAtJC7gT5bmHkvQkEq9rI837rHgnzGC0jyQQ8tkL4gAQWDt+coJsyB2p5wypifyRz6Rh5uixOdEvSCBVEy1W4AsNo0fqD7UielOD6BojjJCilx4xHjGjQUntxyaOrsLC+EsRGiWOefTznTbEBplqiuH9kxoJts+xy9LVZmDS7TtsC98kOmkltOlXVNb6/xF1PYZ9j897buHOSXC8iTgdzEpbaiH7B5HSPh++1/et1SEMWsiMt7lU92vAhErDR8C2jCXMiT+J67ai51LKSLZuovjntnhA6Y8UoELxoi34u1DFuHvF9veBB4CHAOPK1cxwllHTk+5oSDr7QfP/j8W8W9RCMoutbs=";
    private final static String PUBLIC_KEY =
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzAlN8mDG1J5sl/i5u/JirpoOH0v4Li99UWBDFnONRY3nrQo/Xy0lIPzVdCBxmgjShuF8lY2KGJdxK4N8sSwB7jmOx1rME34hK3AaNOYyBYQ1MHsysgQxajCkfGGRpGdre8n9UMpYcAafWecUqJNmcqb+tFtkwwhEn50hzTaL4um0MHJvaGhQ/5ZH2TS1FmkKU5CZXrzVHxetsgO8IDmR68qcwvBUG9z2Et9dqd6qocEjl8GxlYu0E32DffJRoCVLAqdqMdu4fbbUQBV1TEt336F+mrqXWTCfas90Hzr8u+Y+vzy7k+jCYAmpVm3mBx6A0J+vmg5isTUeRygdlx2oIQIDAQAB";

    public static void main(String[] args) {
        KeyPairGenerator keyPairGen = null;
        String privateKeyStr = null;
        String pubKeyStr = null;
        KeyPair keyPair = null;
        try {
            keyPairGen = KeyPairGenerator.getInstance("DSA");
            keyPairGen.initialize(2048);  // DSA key size (2048-bit)
            keyPair = keyPairGen.generateKeyPair();
            privateKeyStr = Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded());
//            pubKeyStr = Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        PrivateKey privateKey;
        try {
            byte[] privateBytes = Base64.getDecoder().decode(privateKeyStr);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("DSA");
            privateKey = keyFactory.generatePrivate(keySpec);
            String result = signData(url, privateKey);
            System.out.println(result);
            Signature signatureVerify = Signature.getInstance("SHA256withRSA");
//            PublicKey publicKey = generatePublicKey(pubKeyStr);
//            signatureVerify.initVerify(keyPair.getPublic());
//            signatureVerify.update(url.getBytes());
//            boolean verify = signatureVerify.verify(Base64.getDecoder().decode(result));
//            System.out.println(verify);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String signData(String data, PrivateKey privateKey) throws Exception {
        Signature sign = Signature.getInstance("SHA256withDSA");
        sign.initSign(privateKey);
        sign.update(data.getBytes());
        byte[] signature = sign.sign();
        return Base64.getEncoder().encodeToString(signature);
    }

    private static PublicKey generatePublicKey(String str) {
        PublicKey pubKey;
        try {
            byte[] publicKeyBytes = Base64.getDecoder().decode(str);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("DSA");
            pubKey = keyFactory.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
        return pubKey;
    }
}
