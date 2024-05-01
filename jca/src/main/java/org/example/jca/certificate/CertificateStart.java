package org.example.jca.certificate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Arrays;

public class CertificateStart {

    public static void main(String[] args) {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            InputStream certificateInputStream = new FileInputStream("/home/user/Documents/jca/src/main/resources/acmeroot1.cer");

            Certificate certificate = certificateFactory.generateCertificate(certificateInputStream);

            byte[] encodedCertificate = certificate.getEncoded();
            System.out.println(Arrays.toString(encodedCertificate));

            PublicKey certificatePublicKey = certificate.getPublicKey();

            String certificateType = certificate.getType();
            System.out.println(certificateType);

            certificate.verify(certificatePublicKey);

        } catch (CertificateException | FileNotFoundException | NoSuchAlgorithmException | SignatureException |
                 InvalidKeyException | NoSuchProviderException e) {
            e.printStackTrace();
        }
    }
}
