package net.pack.leetcodestyle.substringsword;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().numOfStrings(new String[]{"a","bc"}, "bce"));
    }

    public int numOfStrings(String[] patterns, String word){
        int count = 0;
        for(String str : patterns){
            if(word.contains(str)){
                count++;
            }
        }
        return count;
    }
}
