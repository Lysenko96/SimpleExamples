package net.pack.tasksnleet.implstr;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().strStr("hello", "ll"));
    }

    public int strStr(String haystack, String needle) {
        //System.out.println(haystack.contains(needle));
        int result = 0;
        if(!haystack.contains(needle)){
            result = -1;
        } else {
            //System.out.println(haystack.indexOf(needle));
            // begin index needle
            result = haystack.indexOf(needle);
        }
        return result;
    }
}
