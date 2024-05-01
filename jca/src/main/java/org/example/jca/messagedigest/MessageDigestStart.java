package org.example.jca.messagedigest;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.xml.bind.DatatypeConverter;
import java.security.*;
import java.util.Arrays;

public class MessageDigestStart {

    public static void main(String[] args) {

        Security.addProvider(new BouncyCastleProvider());

        Provider[] providers = Security.getProviders();
        for (Provider p : providers) {
            System.out.println(p.getName());
        }


        try {
            MessageDigest digester = MessageDigest.getInstance("MD5");
            byte[] salt = new byte[16];
            System.out.println(Arrays.toString(salt));
            SecureRandom secureRandom = SecureRandom.getInstanceStrong();
//            System.out.println(secureRandom.getAlgorit ;
//            byte[] seed = secureRandom.generateSeed(16);
//            System.out.println(Arrays.toString(seed));
            secureRandom.nextBytes(salt);
            System.out.println(Arrays.toString(salt));
            digester.update(salt);
//            digester.reset();
            byte[] input = "Secret string".getBytes();
            byte[] digest = digester.digest(input);
            System.out.println(DatatypeConverter.printHexBinary(digest));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }
}
