package tasks;

import java.util.ArrayList;
import java.util.List;

public class Main1 {

    public static void main(String[] args) {
        Main1.encrypt("hsi  etTi sats!", 1);
        Main1.decrypt("hsi  etTi sats!", 1);
//        Main1.decrypt("s eT ashi tist!", 2);
//        Main1.decrypt("", 0);
//        Main1.encrypt("", 0);
//        Main1.decrypt(null, 0);
//        Main1.encrypt(null, 0);

    }

    public static String decrypt(final String encryptedText, final int n) {
        if(encryptedText == null) return null;
        if (encryptedText.equals("")) return "";
        if (n == -1) return encryptedText;
        String value = encryptedText;
        StringBuilder sb = null;
        for (int j = 0; j < n; j++) {
            sb = new StringBuilder();
            List<String> odd = new ArrayList<>();
            List<String> even = new ArrayList<>();
            for (int i = 0; i < value.length(); i++) {
                if (i < value.length() / 2) odd.add(value.split("")[i]);
                if (i >= value.length() / 2) even.add(value.split("")[i]);
            }
            int d = 0;
            int c = 0;
            for(int i = 0; i < encryptedText.length(); i++){
                if(i % 2 == 0 && d <= value.length() / 2) sb.append(even.get(d++));
                if(i % 2 != 0 && c < value.length() / 2) sb.append(odd.get(c++));
            }
            value = sb.toString();
        }
        //System.out.println(sb != null ? sb.toString() : encryptedText);
        return  sb != null ? sb.toString() : encryptedText;
    }

    public static String encrypt(final String text, final int n) {
        if(text == null) return null;
        if (text.equals("")) return "";
        if (n == -1) return text;
        String value = text;
        StringBuilder sb = null;
        for (int j = 0; j < n; j++) {
            sb = new StringBuilder();
            List<String> odd = new ArrayList<>();
            List<String> even = new ArrayList<>();
            for (int i = 0; i < value.length(); i++) {
                if (i % 2 == 0) even.add(value.split("")[i]);
                if (i % 2 != 0) odd.add(value.split("")[i]);
            }
            for (String s : odd) sb.append(s);
            for (String s : even) sb.append(s);
            value = sb.toString();
        }
        //System.out.println(sb);
        return  sb != null ? sb.toString() : text;
    }
}
