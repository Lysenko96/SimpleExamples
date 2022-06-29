package intersectiontwoarr;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().intersection(new int[]{4,9,5},  new int[]{9,4,9,8,4})));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(Integer i : nums1){
            for(Integer i1 : nums2){
                if(i.equals(i1)){
                    set.add(i);
                }
            }
        }
        List<Integer> list = new ArrayList<>(set);
        int[] arr = new int[list.size()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}
