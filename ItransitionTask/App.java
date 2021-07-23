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
        //     System.out.println("not correct, need value %2 !=0 and >=3 ");
        // } else {
            SecureRandom random = new SecureRandom();
            byte bytes[] = new byte[16];
            byte[] hmacSha256 = null;
            Mac mac = Mac.getInstance("HmacSHA256");
            // System.out.println(args[0]);
            // System.out.println(Arrays.toString(bytes));
            random.nextBytes(bytes);
            // System.out.println(Arrays.toString(bytes));
            Random random2 = new Random();
            int v = random2.nextInt(5) + 1;
            System.out.println(v);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "HmacSHA256");
            mac.init(secretKeySpec);
           // System.out.println(Arrays.toString(hmacSha256));
            hmacSha256 = mac.doFinal(String.valueOf(v).getBytes());
            // System.out.println(Arrays.toString(hmacSha256));
            System.out.println(String.format("Hex: %032x", new BigInteger(1, hmacSha256)));
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter you move: ");
            int s = sc.nextInt();
            System.out.println(s);
            
        //}
    }
}
