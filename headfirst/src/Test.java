import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        //System.out.println(accum("ZpglnRxqenU"));
        new Test().squareDigits(811181);
        new Test().squareDigits2(9119);

    }


    public static String accum(String s) {
        // your code
        String[] arrStr = s.split("");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrStr.length; i++) {
            int counter = i;
            sb.append(arrStr[i].toUpperCase());
            while (counter > 0) {
                sb.append(arrStr[i].toLowerCase());
                counter--;
            }
            sb.append("-");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
        return sb.toString();
    }

    public int squareDigits(int n) {
       String s = String.valueOf(n);
       String[] strNumber = s.split("");
       List<Integer> numbers = new ArrayList<>();
       StringBuilder sb = new StringBuilder();
       for(int i = 0; i < strNumber.length; i++) {
           sb.append(strNumber[i]);
           if(!sb.toString().isEmpty() && Math.sqrt(new Integer(strNumber[i])) == new Integer(strNumber[i]) * new Integer(strNumber[i])) {
               numbers.add(new Integer(sb.toString()));
               sb = new StringBuilder();
           }
       }
       StringBuilder result = new StringBuilder();
       for(Integer number : numbers){
           int val = (int) Math.sqrt(number);
           result.append(val);
       }
        return new Integer(result.toString());
    }

    public int squareDigits2(int n) {
        String s = String.valueOf(n);
        String[] strNumber = s.split("");
        List<Integer> numbers = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strNumber.length; i++) {
            numbers.add((int) Math.pow(new Integer(strNumber[i]), 2));
        }
        StringBuilder result = new StringBuilder();
        for(Integer number : numbers){
            result.append(number);
        }
        System.out.println(result);
        return new Integer(result.toString());
    }
}
