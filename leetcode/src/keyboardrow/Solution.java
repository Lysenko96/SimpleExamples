package keyboardrow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
    }

    public String[] findWords(String[] words) {
        String[] first = "qwertyuiop".split("");
        List<String> firstL = Arrays.asList(first);
        String[] second = "asdfghjkl".split("");
        List<String> secondL = Arrays.asList(second);
        String[] third = "zxcvbnm".split("");
        List<String> thirdL = Arrays.asList(third);
        List<String> result = new ArrayList<>();
        for(String word : words){
            String[] letters = word.split("");
            List<String> strings = Arrays.stream(letters).map(String::toLowerCase).toList();
            int fL = 0;
            int sL = 0;
            int tL = 0;
            for(String letter : strings) {
                if(firstL.contains(letter))
                    fL++;
                else if(secondL.contains(letter))
                    sL++;
                else if(thirdL.contains(letter))
                    tL++;
            }
//            System.out.println(fL);
//            System.out.println(sL);
//            System.out.println(tL);
//            System.out.println(letters.length);
            if (letters.length == fL)
                result.add(word);
            else if (letters.length == sL)
                result.add(word);
            else if (letters.length == tL)
                result.add(word);

          //  System.out.println(result);
        }
        String[] arr = new String[result.size()];
        for(int i = 0; i < result.size(); i++)
            arr[i] = result.get(i);
        return arr;
    }
}
