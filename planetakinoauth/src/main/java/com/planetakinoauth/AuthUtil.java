package com.planetakinoauth;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class AuthUtil {

    private final static String PUBLIC_KEY =
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzAlN8mDG1J5sl/i5u/JirpoOH0v4Li99UWBDFnONRY3nrQo/Xy0lIPzVdCBxmgjShuF8lY2KGJdxK4N8sSwB7jmOx1rME34hK3AaNOYyBYQ1MHsysgQxajCkfGGRpGdre8n9UMpYcAafWecUqJNmcqb+tFtkwwhEn50hzTaL4um0MHJvaGhQ/5ZH2TS1FmkKU5CZXrzVHxetsgO8IDmR68qcwvBUG9z2Et9dqd6qocEjl8GxlYu0E32DffJRoCVLAqdqMdu4fbbUQBV1TEt336F+mrqXWTCfas90Hzr8u+Y+vzy7k+jCYAmpVm3mBx6A0J+vmg5isTUeRygdlx2oIQIDAQAB";

    private static final String url = "api/v1.0/customer?page=1&perPage=25&sortOrder=desc&sortBy=createdAt";

    public static void main(String[] args) {
        byte[] privateKeyBytes = null;
        try {
            privateKeyBytes = Files.readAllBytes(Paths.get("/home/user/private.key"));
            KeyFactory keyFactory = KeyFactory.getInstance("DSA");
            String keyString = new String(privateKeyBytes);
            keyString = keyString.replace("-----BEGIN PRIVATE KEY-----", "")
                    .replace("-----END PRIVATE KEY-----", "")
                    .replaceAll("\\s", "");
            byte[] privateBytes = Base64.getDecoder().decode(keyString);
            DSAPrivateKey privateKey = (DSAPrivateKey) keyFactory.generatePrivate(new PKCS8EncodedKeySpec(privateBytes));
            // Example data to sign

            // Call the signData method
            String signedData = AuthUtil.signData(url, privateKey);

            System.out.println("Signed Data (Base64): " + signedData);

//            Signature signatureVerify = Signature.getInstance("SHA256withDSA");
//            PublicKey publicKey = generatePublicKey();
//            signatureVerify.initVerify(publicKey);
//            signatureVerify.update(url.getBytes());
//            boolean verify = signatureVerify.verify(Base64.getDecoder().decode(signedData));
//            System.out.println(verify);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
//    private static PublicKey generatePublicKey() {
//        PublicKey pubKey;
//        try {
//            String publicKeyStr = PUBLIC_KEY;
//            byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyStr);
//            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
//            KeyFactory keyFactory = KeyFactory.getInstance("DSA");
//            pubKey = keyFactory.generatePublic(keySpec);
//        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
//            throw new RuntimeException(e);
//        }
//        return pubKey;
//    }



    public static String signData(String data, PrivateKey privateKey) throws Exception {
        // Initialize the signature instance with SHA-256 algorithm
        Signature signature = Signature.getInstance("SHA256withDSA");

        // Initialize the signature object with the private key
        signature.initSign(privateKey);

        // Update the signature with the data to be signed
        signature.update(data.getBytes());

        // Generate the signature
        byte[] signedData = signature.sign();

        // Return the signature encoded in Base64
        return Base64.getEncoder().encodeToString(signedData);
    }
}
