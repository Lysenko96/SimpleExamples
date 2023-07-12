package net.pack.leetcodestyle.concatarr;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().getConcatenation(new int[]{1, 2, 3, 4})));
    }
    public int[] getConcatenation(int[] nums) {
        int[] n = new int[nums.length*2];
        boolean f = true;
        int p = 0;
        for(int i = 0; i < n.length; i++){
            if(p > n.length/2-1 && f){
                p = 0;
                f = false;
            }
            n[i] = nums[p];
            p++;
        }
        //System.out.println(Arrays.toString(n));
        return n;
    }
}