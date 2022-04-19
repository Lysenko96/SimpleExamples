package net.pack.tasksnleet.convertbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
       // System.out.println(0 % 2);
        System.out.println(new Solution().minBitFlips(10, 7));
    }

    public int minBitFlips(int start, int goal) {
        String dec = Integer.toBinaryString(start);
        String bin = Integer.toBinaryString(goal);
       // System.out.println(dec);
        //System.out.println(bin);
        String[] decArr = dec.split("");
        String[] binArr = bin.split("");
        int length = Math.max(decArr.length, binArr.length);
        int min = Math.min(decArr.length, binArr.length);
        int diff = length - min;
        List<String> arrStr = new ArrayList<>();
        if(decArr.length < binArr.length){
            arrStr.addAll(Arrays.asList(decArr));
            for(int i = 0; i < diff; i++){
                arrStr.add(0,"0");
            }
            decArr = new String[arrStr.size()];
            for(int k = 0; k < decArr.length; k++){
                decArr[k] = arrStr.get(k);
            }
        } else if(decArr.length > binArr.length) {
            arrStr.addAll(Arrays.asList(binArr));
            for(int i = 0; i < diff; i++){
                arrStr.add(0,"0");
            }
            binArr = new String[arrStr.size()];
            for(int k = 0; k < binArr.length; k++){
                binArr[k] = arrStr.get(k);
            }
        }
       // System.out.println(arrStr);
        int count = 0;
        for(int i = length-1; i >= 0; i--){
            if(!decArr[i].equals(binArr[i])){
                count++;
            }
        }
        //System.out.println(count);
        return count;
    }

}
