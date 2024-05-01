package org.example.jca.symmetrickeycrypto;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.security.SecureRandom;

public class SymmetricKeyCryptoStart {

    public static void main(String[] args) {
//        Mac mac;
        try {
            // Initialization Vector
            SecureRandom random = SecureRandom.getInstanceStrong();
            byte[] rnd = new byte[16];
            random.nextBytes(rnd);
            IvParameterSpec ivSpec = new IvParameterSpec(rnd);
            String text = "Hello World!";
            // Generate new key
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            keygen.init(256, random);
            Key key = keygen.generateKey();
            // Encrypt with key
            String transformation = "AES/CBC/PKCS5Padding";
//            String transformation = "AES/ECB/PKCS5Padding";
            Cipher cipher = Cipher.getInstance(transformation);
            cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
//            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encrypted = cipher.doFinal(text.getBytes());
            System.out.println(DatatypeConverter.printHexBinary(encrypted));
            // Decrypt with key
            cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
//            cipher.init(Cipher.DECRYPT_MODE, key);
            String result = new String(cipher.doFinal(encrypted));
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
