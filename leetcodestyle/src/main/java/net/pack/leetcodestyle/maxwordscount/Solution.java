package net.pack.leetcodestyle.maxwordscount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().mostWordsFound(new String[]{"hello", "what's up"}));
    }
    public int mostWordsFound(String[] sentences){
        List<Integer> maxLengths = new ArrayList<>();
        for(String string : sentences){
            maxLengths.add(string.split(" ").length);
        }
        return Collections.max(maxLengths);
    }
}
