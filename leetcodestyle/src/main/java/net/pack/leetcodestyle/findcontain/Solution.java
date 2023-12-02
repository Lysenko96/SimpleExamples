package net.pack.leetcodestyle.findcontain;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().findWordsContaining(new String[]{"a", "aa", "aaaa", "a"}, 'a'));
    }

    public List<Integer> findWordsContaining(String[] words, char x) {
       List<Integer> result = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            if(words[i].contains(String.valueOf(x))){
                result.add(i);
            }
        }
       return result;
    }
}
