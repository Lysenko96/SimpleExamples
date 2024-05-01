package org.example.jca.mac;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public class MacStart {

    public static void main(String[] args) {
        try {
            SecureRandom random = SecureRandom.getInstanceStrong();
            byte[] salt = new byte[16];
            random.nextBytes(salt);
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(salt, "HmacSHA256"));
            byte[] data = "Hello World".getBytes();
            byte[] data1 = "Hello World".getBytes();
            mac.update(data);
            byte[] hash = mac.doFinal();
            byte[] hash1 = mac.doFinal(data1);
            System.out.println(Arrays.toString(hash).equals(Arrays.toString(hash1))); // true
            System.out.println(Arrays.toString(hash));
            System.out.println(Arrays.toString(hash1));
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }
}
