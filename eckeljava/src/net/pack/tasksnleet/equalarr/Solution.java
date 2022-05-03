package net.pack.tasksnleet.equalarr;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().canBeEqual(new int[]{1,2,3,4}, new int[]{2,4,1,3}));
    }

    public boolean canBeEqual(int[] target, int[] arr) {
        List<Integer> l = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        for(Integer i : arr){
            l.add(i);
        }
        Collections.reverse(l);
        Collections.sort(l);
        for(Integer i : target){
            t.add(i);
        }
        Collections.sort(t);
        return t.equals(l);
    }
}
