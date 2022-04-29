package net.pack.tasksnleet.heightchecker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().heightChecker(new int[]{1,1,4,2,1,3}));
    }

    public int heightChecker(int[] heights) {
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < heights.length; i++){
            list.add(heights[i]);
        }
        Collections.sort(list);
        for(int i = 0; i < heights.length; i++){
            if(heights[i] != list.get(i)){
                count++;
            }
        }
        return count;
    }

}
