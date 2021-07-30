import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import java.math.BigInteger;

public class App {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {

        // int input = Integer.valueOf(args[0]);
        // if (input < 3 || input % 2 == 0) {
        // System.out.println("not correct, need value %2 !=0 and >=3 ");
        // } else {

        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[16];
        byte[] hmacSha256 = null;
        Mac mac = Mac.getInstance("HmacSHA256");

        random.nextBytes(bytes);

        Random random2 = new Random();
        int compStep = random2.nextInt(Integer.parseInt(args[0]) - 1) + 1;
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "HmacSHA256");
        mac.init(secretKeySpec);
        hmacSha256 = mac.doFinal(String.valueOf(compStep).getBytes());
        System.out.println(String.format("HMAC: %032X", new BigInteger(1, hmacSha256)));
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter you move: ");
        int userMove = sc.nextInt();
        System.out.println("comp move: " + compStep);
        int compMove = compStep % 5;
        if (compMove == 0) {
            compMove = 5;
        }
        System.out.println("user move: " + userMove);
        System.out.println("diff: " + Integer.parseInt(args[0]) / 2);
        int diff = Integer.parseInt(args[0]) / 2;
        // System.out.println("user win: ");
        Set<Integer> compSet = new HashSet<>();
        Set<Integer> userSet = new HashSet<>();
        // Set<Integer> userLoss = new HashSet<>();

        for (int i = userMove; i < userMove + diff; i++) {
            if ((i + 1) % 5 == 0) {
                // System.out.println(5);
                compSet.add(5);
            } else {
                // System.out.println((i + 1) % 5);
                compSet.add((i + 1) % 5);
            }
        }
        System.out.println("comp win");
        System.out.println(compSet);
        // System.out.println("loss: ");
        // int count = userMove;
        // for (int i = userMove; i < userMove + diff; i++) {
        // count--;
        // userLoss.add(count);
        // if (count == 0) {
        // count = 5;
        // userLoss.add(count);
        // }
        // // System.out.println(count);
        // }

        for (int i = compMove; i < compMove + diff; i++) {
            if ((i + 1) % 5 == 0) {
                // System.out.println(5);
                userSet.add(5);
            } else {
                // System.out.println((i + 1) % 5);
                userSet.add((i + 1) % 5);
            }
        }
        System.out.println("user win: ");
        System.out.println(userSet);
        if (compSet.contains(compMove)) {
            System.out.println("You loss");
        } else if (userSet.contains(userMove)) {
            System.out.println("You win");
        } else {
            System.out.println("draw");
        }

        // System.out.println("user loss");
        // System.out.println(userLoss);
        System.out.println(String.format("HMAC key: %032X", new BigInteger(1, bytes)));
        sc.close();
        // }
    }
}
