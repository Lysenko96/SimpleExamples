package edu.lysenko.task3;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HMAC {

	byte[] getKey() {
		SecureRandom random = new SecureRandom();
		byte key[] = new byte[16];
		random.nextBytes(key);
		return key;
	}

	String getHMAC(byte[] key, int compMove) throws NoSuchAlgorithmException, InvalidKeyException {
		Mac mac = Mac.getInstance("HmacSHA256");
		SecretKeySpec secretKeySpec = new SecretKeySpec(key, "HmacSHA256");
		mac.init(secretKeySpec);
		byte[] stepCompBytes = mac.doFinal(String.valueOf(compMove).getBytes());
		return String.format("HMAC: %02X", new BigInteger(1, stepCompBytes));
	}
}