package org.example.jca.signature;

import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Signature;
import java.util.Arrays;

public class SignatureStart {

    public static void main(String[] args) {
        try {
// Generate keys
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            SecureRandom random = SecureRandom.getInstanceStrong();
            generator.initialize(2048, random);
            KeyPair keyPair = generator.generateKeyPair();
            KeyPair keyPair1 = generator.generateKeyPair();
            // Digital Signature
            Signature dsa = Signature.getInstance("SHA256withRSA");
            dsa.initSign(keyPair.getPrivate());
//            dsa.initSign(keyPair1.getPrivate());
            // Update and sign the data
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
            byte[] data = cipher.doFinal("Hello World!".getBytes());
//            byte[] data = "Hello World!".getBytes();
            dsa.update(data); // add data to signature
            byte[] signature = dsa.sign();
            // Verify signature
            dsa.initVerify(keyPair.getPublic());
            dsa.update(data); // add data to signature
            boolean verifies = dsa.verify(signature);
            System.out.println("Signature is ok: " + verifies);
            // Decrypt if signature is correct
            if (verifies) {
                cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
                byte[] result = cipher.doFinal(data);
                System.out.println(new String(result));
//                System.out.println(Arrays.toString(data));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
