package net.pack.leetcodestyle.findorigarrxor;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findArray(new int[]{5,2,0,3,1})));
    }

    public int[] findArray(int[] pref) {
        if(pref.length==1) return pref;
        int[] result = new int[pref.length];
        result[0] = pref[0];
        for(int i = 0; i < pref.length-1; i++){
             pref[i] ^= pref[i + 1];
             result[i + 1] = pref[i];
        }
        return result;
    }
}
