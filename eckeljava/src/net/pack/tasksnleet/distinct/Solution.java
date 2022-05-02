package net.pack.tasksnleet.distinct;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().kthDistinct(new String[]{"a", "a"}, 1));
    }

    public String kthDistinct(String[] arr, int k) {
        Set<String> set = new HashSet<>();
        for (int j = 0; j < arr.length; j++) {
            //int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (i != j && arr[i].equals(arr[j])) {
                    // System.out.println(arr[j]);
                    set.add(arr[j]);
                    // count++;
                }
            }
        }
        List<String> arrList = new ArrayList<>(Arrays.asList(arr));
        arrList.removeAll(set);
        if(k-1 >= arrList.size()){
            return "";
        }
        //System.out.println(arrList);
        return arrList.get(k-1);
    }
}
