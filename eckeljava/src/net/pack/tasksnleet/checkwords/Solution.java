package net.pack.tasksnleet.checkwords;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    final static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        System.out.println(new Solution().isSumEqual("aaa", "a", "aa"));
    }

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int first = getNumberByWord(firstWord);
        int second = getNumberByWord(secondWord);
        int sum = getNumberByWord(targetWord);
        return first + second == sum;
    }

    private int getNumberByWord(String word){
        StringBuilder sb = new StringBuilder();
        String[] alphabetArr = alphabet.split("");
        String[] firstWordArr = word.split("");
        for(String letter : firstWordArr) {
            for (int i = 0; i < alphabetArr.length; i++) {
                if(letter.equals(alphabetArr[i])){
                   sb.append(i);
                }
            }
        }
        return new Integer(sb.toString());
    }
}
