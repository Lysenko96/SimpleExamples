package com.planetakinoauth.rsa;

import com.planetakinoauth.ts.Main;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class SignWithRsa {
//        private static final String url = "https://api-integration.dev.planeta8.net/api/v1.0/customer?page=1&perPage=25&sortOrder=desc&sortBy=createdAt";
        private static final String url = "/api/v1.0/customer?page=1&perPage=25&sortOrder=desc&sortBy=createdAt";
//    private static final String url = "api/v1.0/customer?page=1&perPage=25&sortOrder=desc&sortBy=createdAt";
    // openssl rsa -in private_key.pem -pubout -out public_key.pem // generate public key
    private final static String PRIVATE_KEY =
//        "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDMCU3yYMbUnmyX+Lm78mKumg4fS/guL31RYEMWc41FjeetCj9fLSUg/NV0IHGaCNKG4XyVjYoYl3Erg3yxLAHuOY7HWswTfiErcBo05jIFhDUwezKyBDFqMKR8YZGkZ2t7yf1QylhwBp9Z5xSok2Zypv60W2TDCESfnSHNNovi6bQwcm9oaFD/lkfZNLUWaQpTkJlevNUfF62yA7wgOZHrypzC8FQb3PYS312p3qqhwSOXwbGVi7QTfYN98lGgJUsCp2ox27h9ttRAFXVMS3ffoX6aupdZMJ9qz3QfOvy75j6/PLuT6MJgCalWbeYHHoDQn6+aDmKxNR5HKB2XHaghAgMBAAECggEAAlkcx1DyOx+/VOZmPV9ohFLi1Nzx4gR45M3scN6h/e6Rf6Bf6+ZEmsMU+zaAqC9dqgVJS/i8quZ/RUaR5AGDSizFQYUSoAXyN1kdkKokGM0nxh6zsnCffBpwNHKGuDNINE8jtfOqwnRtoJ2YrsRAo6VJWK66AVjf8LqXa349bFCTYNTGG/K7udwliCqLeHWC8C2p/KAryjRE2k5zimulyy9IC9tNSQNvyZMXaWNkw7swTeu1tZttTobha2x4MqxHxX+KGcHA78vveaCYRc7oBVTDd7Cli4dZiCQIHkLu9f9/bbbq04dYumDSGaZBLW6y9xh+wvmY4DsWOPvdNNDBGQKBgQDqdGTHDGnhAOPkQjcB75ncouNZFt7e6oCwEifk1SzfeOKNHSXPpjPgZ0EUqtbpb1pUist4kp7ePgGZ3uKEg1MCoZOnMq3hhCR07RgGhoQ3NCUyhgidxiWFOxuiAYfd7O6UjWZmDjn65u9DiAUc1e6TphZZYgWEWm66TtTOFsgx5QKBgQDeyU/j5tkv3DcwmA5Vcceyjzubx2nVfj/iZXJtp2gTUJ+KG/y0TwMHBdNWVnM6ZwEXEZyqwc5XJYyccbBhll4YvaKNxqpkVCtQE8Kf7N9vI55bTExPSu1CwECL0/pr23F4kQBot9W53kKBespCi9Tl48FdxOVaJHSg/objI6KpjQKBgQDDuMLgf/ZrhUi5pqUxEopJbBmKp9MKGI2xbparK2K4c7v8vZZxEHhCHzBvRmb+nJy18uAFGbFSKkU/5JcItHC5w5T1gRMzLhMZIUxrNiRtyTQ8RzQuMdnkrQFWbxyzITXSAXC4RawVTm/y2jwaZGU0EPSbTX75jFzfXyu7l70sGQKBgQDeici7pgScwiR+7eSjhRwtSNYKLY+SKqI1y5AZ6HcVlBtJIduzYJltkmwgegpv9CQqnvUXvLAYbPGf9BBz6nfjzslpRWE/BrSdMJ/gkARASBwOppAzRGzrmI7hHcWvp2wZOv5lm/xpxZI5NCaFgpgPawnkWKGhAXlet+CVUytQoQKBgQDkiTaxCtqOgDv9EgWZF2gHw2iv3VCCUBwZNs2Qc4N+zvHqE8x/S7X7qPuNFuzrHD6f3oSqKdB1Ce//F9cCOs5ah2Iwj2nx9XqRlF8lfjOSd7f9n/vBk42YNeOfq1yhn1IAxwJrCgD4W/NG2G3qgKTZZTBdpLMnxRr3l320uqBAxg==";
    "-----BEGIN PRIVATE KEY-----\n" +
            "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDMCU3yYMbUnmyX\n" +
            "+Lm78mKumg4fS/guL31RYEMWc41FjeetCj9fLSUg/NV0IHGaCNKG4XyVjYoYl3Er\n" +
            "g3yxLAHuOY7HWswTfiErcBo05jIFhDUwezKyBDFqMKR8YZGkZ2t7yf1QylhwBp9Z\n" +
            "5xSok2Zypv60W2TDCESfnSHNNovi6bQwcm9oaFD/lkfZNLUWaQpTkJlevNUfF62y\n" +
            "A7wgOZHrypzC8FQb3PYS312p3qqhwSOXwbGVi7QTfYN98lGgJUsCp2ox27h9ttRA\n" +
            "FXVMS3ffoX6aupdZMJ9qz3QfOvy75j6/PLuT6MJgCalWbeYHHoDQn6+aDmKxNR5H\n" +
            "KB2XHaghAgMBAAECggEAAlkcx1DyOx+/VOZmPV9ohFLi1Nzx4gR45M3scN6h/e6R\n" +
            "f6Bf6+ZEmsMU+zaAqC9dqgVJS/i8quZ/RUaR5AGDSizFQYUSoAXyN1kdkKokGM0n\n" +
            "xh6zsnCffBpwNHKGuDNINE8jtfOqwnRtoJ2YrsRAo6VJWK66AVjf8LqXa349bFCT\n" +
            "YNTGG/K7udwliCqLeHWC8C2p/KAryjRE2k5zimulyy9IC9tNSQNvyZMXaWNkw7sw\n" +
            "Teu1tZttTobha2x4MqxHxX+KGcHA78vveaCYRc7oBVTDd7Cli4dZiCQIHkLu9f9/\n" +
            "bbbq04dYumDSGaZBLW6y9xh+wvmY4DsWOPvdNNDBGQKBgQDqdGTHDGnhAOPkQjcB\n" +
            "75ncouNZFt7e6oCwEifk1SzfeOKNHSXPpjPgZ0EUqtbpb1pUist4kp7ePgGZ3uKE\n" +
            "g1MCoZOnMq3hhCR07RgGhoQ3NCUyhgidxiWFOxuiAYfd7O6UjWZmDjn65u9DiAUc\n" +
            "1e6TphZZYgWEWm66TtTOFsgx5QKBgQDeyU/j5tkv3DcwmA5Vcceyjzubx2nVfj/i\n" +
            "ZXJtp2gTUJ+KG/y0TwMHBdNWVnM6ZwEXEZyqwc5XJYyccbBhll4YvaKNxqpkVCtQ\n" +
            "E8Kf7N9vI55bTExPSu1CwECL0/pr23F4kQBot9W53kKBespCi9Tl48FdxOVaJHSg\n" +
            "/objI6KpjQKBgQDDuMLgf/ZrhUi5pqUxEopJbBmKp9MKGI2xbparK2K4c7v8vZZx\n" +
            "EHhCHzBvRmb+nJy18uAFGbFSKkU/5JcItHC5w5T1gRMzLhMZIUxrNiRtyTQ8RzQu\n" +
            "MdnkrQFWbxyzITXSAXC4RawVTm/y2jwaZGU0EPSbTX75jFzfXyu7l70sGQKBgQDe\n" +
            "ici7pgScwiR+7eSjhRwtSNYKLY+SKqI1y5AZ6HcVlBtJIduzYJltkmwgegpv9CQq\n" +
            "nvUXvLAYbPGf9BBz6nfjzslpRWE/BrSdMJ/gkARASBwOppAzRGzrmI7hHcWvp2wZ\n" +
            "Ov5lm/xpxZI5NCaFgpgPawnkWKGhAXlet+CVUytQoQKBgQDkiTaxCtqOgDv9EgWZ\n" +
            "F2gHw2iv3VCCUBwZNs2Qc4N+zvHqE8x/S7X7qPuNFuzrHD6f3oSqKdB1Ce//F9cC\n" +
            "Os5ah2Iwj2nx9XqRlF8lfjOSd7f9n/vBk42YNeOfq1yhn1IAxwJrCgD4W/NG2G3q\n" +
            "gKTZZTBdpLMnxRr3l320uqBAxg==\n" +
            "-----END PRIVATE KEY-----";
    private final static String PUBLIC_KEY =
            "-----BEGIN PUBLIC KEY-----\n" +
                    "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzAlN8mDG1J5sl/i5u/Ji\n" +
                    "rpoOH0v4Li99UWBDFnONRY3nrQo/Xy0lIPzVdCBxmgjShuF8lY2KGJdxK4N8sSwB\n" +
                    "7jmOx1rME34hK3AaNOYyBYQ1MHsysgQxajCkfGGRpGdre8n9UMpYcAafWecUqJNm\n" +
                    "cqb+tFtkwwhEn50hzTaL4um0MHJvaGhQ/5ZH2TS1FmkKU5CZXrzVHxetsgO8IDmR\n" +
                    "68qcwvBUG9z2Et9dqd6qocEjl8GxlYu0E32DffJRoCVLAqdqMdu4fbbUQBV1TEt3\n" +
                    "36F+mrqXWTCfas90Hzr8u+Y+vzy7k+jCYAmpVm3mBx6A0J+vmg5isTUeRygdlx2o\n" +
                    "IQIDAQAB\n" +
                    "-----END PUBLIC KEY-----\n";
    public static void main(String[] args) {
        SignWithRsa signWithRsa = new SignWithRsa();
        System.out.println(signWithRsa.calculateHash(PUBLIC_KEY, "MD5"));
        System.out.println(signWithRsa.sign(url));
    }

    private String sign(String url) {
        try {
            Signature signature = Signature.getInstance("SHA256withRSA");
            PrivateKey privateKey = generatePrivateKey();
            signature.initSign(privateKey);
            signature.update(url.getBytes());

            byte[] signed = signature.sign();

            String base64Sign = Base64.getEncoder().encodeToString(signed);

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
            String result = PUBLIC_KEY
                    .replace("-----BEGIN PUBLIC KEY-----", "")
                    .replace("-----END PUBLIC KEY-----", "")
                    .replace("\n", "")
                    .replace(" ", "");
            byte[] publicKeyBytes = Base64.getDecoder().decode(result);
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
            String result = PRIVATE_KEY
                    .replace("-----BEGIN PRIVATE KEY-----", "")
                    .replace("-----END PRIVATE KEY-----", "")
                    .replace("\n", "")
                    .replace(" ", "");
            byte[] privateBytes = Base64.getDecoder().decode(result);
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
