package net.pack.pivot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().pivotArray(new int[]{-3,4,3,2}, 2)));
    }

    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> lessList = new ArrayList<>();
        List<Integer> moreList = new ArrayList<>();
        int[] res = new int[nums.length];
        for(Integer n : nums){
            if(n < pivot){
                lessList.add(n);
            } else if(n > pivot) {
                moreList.add(n);
            }
        }
        System.out.println(lessList);
        for(Integer i : nums){
            if(i.equals(pivot)){
                lessList.add(i);
            }
        }
        System.out.println(lessList);
        //Collections.sort(moreList);
        lessList.addAll(moreList);
        for(int i =0; i < lessList.size();  i++){
            res[i] = lessList.get(i);
        }
        return res;
    }
}
