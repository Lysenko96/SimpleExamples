package net.pack.tasksnleet.countbits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().countBits(5)));
    }

    public int[] countBits(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            int count = 0;
            String[] arr = Integer.toBinaryString(i).split("");
            for (String w : arr) {
                if (w.equals("1")) {
                    count++;
                }
            }
            list.add(count);
        }
       // System.out.println(list);
        int[] arrInt = new int[list.size()];
        for(int i = 0; i < arrInt.length; i++){
            arrInt[i] = list.get(i);
        }
        return arrInt;
    }
}
