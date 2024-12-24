package com.planetakinoauth;

import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Main {

    private static final String url = "api/v1.0/returns/import/one";
    private String host = "https://api-integration.planetakino.ua/";
    private String apiKeyTest = "e892045238b81b1ac0ea7178317ddd0e36805fb3";


    private final static String PRIVATE_KEY =
            "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC4tseY7SQBtsMMqoFp9NeqgGZa6h8sSVQYwEAFUDVdavPr+5iCgsGlf2KeBDUH7U9x5/UWggbBlF4I+l1MnPBaj2iBaZmn1ZVLDNwraOg6az8T8cdU+/ITXAslTAnPEwOunKVdEQu6xFk8URY4HzGxNfpmV6fk9D+QQHKstGN0/nqeQ2w0HFc/QKcptUBJ03+9PU8E0x0L9QgluBQYv1o4VIQ9h4GTa9OKFza7C4cl4+4S5qzfVDWDTba4RYer3Q6+dlwzn2glckns2VbNPdShiCUv9fUHj9BJuIg56x6YJVSkm9EXfXABWbSLfZyWGWf9n+yAAHqn4HhQMqC3dpPFAgMBAAECggEBAIkfDt8Es+Ud0n/1l2qb2vn0pYc6I/gRW3+gQCZxm5wEyJzXQikofi6oeQIK539B+Ob7JeMWlYNg68nIajh0jKz9prvjM7D3CgQTwOHs1/B+Ku5YXvxEqDkc7B087E8vs10NZmjHPajhF8mB/HefGJmQE5mj2rxJYWJppXd11htDh9GEWZmpqRCGUEGR9omG9vKbsFF8RvQClCOWUhCNqSJ+OcUWTM719jOOhxQcMfxIXHOeQWc4KH5hYOrVF+rMJNjxtrXswXDQtNBYi8s3bMJMadzrY62Y2Cd20Naz3f1r471JxBojXy8PvIeQQsmw5M4sCkFBYZ4php4gTImyg2ECgYEA2YgHDrObwBjkCzp0ZVbC5omRqeVRnIcrMVgUoMcUcD4NoP0Yl48rDPfM08qpFaBevMFyCPTZsqWrGiCUK+Y8UUfv32VG7qSJhIhP2O8ObxlU9Sccj3HPSiqT49bbHtgzdH2m5Ts5GviYG8q/TaSJa9jFyVQBc+46mZHtqAebgVkCgYEA2WEPYqSRA7QJyssDVO9iUygiBh2yqDKcBxCvHjp4FGojoZH2OecGJV5LETOVbRf+8LDYm2ejA5osFDuZCKIqy4G4SIkZ1ZBePxdbn1Mi8RCptRTohu916RemdryV/cvLoCD+BGhy0eiwsojzrGQiCJPgC1lwwlUgt5c8kIgUjE0CgYB6L9om++QkhtaxJ+hxc8aOT/+t+s1YquQsF1me5bQpR/HH1+KUXyrDYf1/iXpoV2hfhhlTxpTxr/Tn/By+e9itn0axqOWq7mkANMEFDWKCLSx3d7ynJjpVYo0nkWwLa02bxWiVoip1Z+Wo1r2WEzHNjjmq2LDoOYxY7osbswo6IQKBgEjb3VpEqk5Bc97CuLUpHx2cH/tIzO7PN7iugONy2XiOMq8eyxaRNmAkAKkdTwInvs1RmOhNjjfQ3uFRMHPSVuGq8uds/Hm2T8B5xb3bEaUW3qrQ/Tbs3+pmgObfQq60NeXP6RP1Jjbw9PiCKponXbjeR4PGUKLyAWtHh4cx9SEpAoGBAKzXHxFZDcQLf8rov7tRZwaKYka4ML5IJZmC9P7ANdD99QD8dmLMN8HHR4OglNOJFwfwd0ZANQbSDD1ZQ/RJJl8V7+g1Bx+Yfo7+XINmtCy7Av9JUpySVJnlmvfpyLfT93P6icvLP5W9X/h/mV6fdLT//6XGY6vmhyi4eL7sk1q4";

    private final static String PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuLbHmO0kAbbDDKqBafTXqoBmWuofLElUGMBABVA1XWrz6/uYgoLBpX9ingQ1B+1Pcef1FoIGwZReCPpdTJzwWo9ogWmZp9WVSwzcK2joOms/E/HHVPvyE1wLJUwJzxMDrpylXRELusRZPFEWOB8xsTX6Zlen5PQ/kEByrLRjdP56nkNsNBxXP0CnKbVASdN/vT1PBNMdC/UIJbgUGL9aOFSEPYeBk2vTihc2uwuHJePuEuas31Q1g022uEWHq90OvnZcM59oJXJJ7NlWzT3UoYglL/X1B4/QSbiIOesemCVUpJvRF31wAVm0i32clhln/Z/sgAB6p+B4UDKgt3aTxQIDAQAB";

    public static void main(String[] args) {
        Main main = new Main();
//        String res = main.calculateHash("text");
//        System.out.println(res);
//        System.out.println(res.equalsIgnoreCase("1cb251ec0d568de6a929b520c4aed8d1"));
        main.sign(url);
    }

    private String sign(String url) {
        Signature signature = null;
        try {
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
            keyPairGen.initialize(2048); // Key size
//            KeyPair keyPair = keyPairGen.generateKeyPair();
//            PrivateKey privateKey = keyPair.getPrivate();
//            System.out.println("PRIVATE");
//            System.out.println(Base64.getEncoder().encodeToString(privateKey.getEncoded()));
//            PublicKey publicKey = keyPair.getPublic();
//            System.out.println("PUBLIC");
//            System.out.println(Base64.getEncoder().encodeToString(publicKey.getEncoded()));

            signature = Signature.getInstance("SHA256withRSA");
            PrivateKey privateKey = generatePrivateKey();
//            System.out.println(privateKey);
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
//            StringBuilder pkcs8Lines = new StringBuilder();
//            BufferedReader rdr = new BufferedReader(new StringReader(PRIVATE_KEY));
//            String line;
//            while ((line = rdr.readLine()) != null) {
//                pkcs8Lines.append(line);
//            }
//            String pkcs8Pem = pkcs8Lines.toString();
//            pkcs8Pem = pkcs8Pem.replace("-----BEGIN OPENSSH PRIVATE KEY-----", "");
//            pkcs8Pem = pkcs8Pem.replace("-----END OPENSSH PRIVATE KEY-----", "");
//            pkcs8Pem = pkcs8Pem.replaceAll("\\s+", "");
//            System.out.println(pkcs8Pem);
            byte[] privateBytes = Base64.getDecoder().decode(PRIVATE_KEY);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            privateKey = keyFactory.generatePrivate(keySpec);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
        return privateKey;
    }

    private String calculateHash(String text) {
        StringBuilder hash;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(text.getBytes());
            hash = new StringBuilder();
            for (byte b : digest) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) {
                    hash.append("0");
                }
                hash.append(hex);
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        return hash.toString();
    }
}
