package finddifftwoarr;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().findDifference(new int[]{1,2,3,3}, new int[]{1,1,2,2}));
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> l = new HashSet<>();
        Set<Integer> l2 = new HashSet<>();
        for(Integer i : nums1){
            l.add(i);
        }
        for(Integer i : nums2){
            l2.add(i);
        }
        for(int i = 0; i < nums2.length; i++){
            if(l.contains(nums2[i])) l.remove(nums2[i]);
        }
        for(int i = 0; i < nums1.length; i++){
            if(l2.contains(nums1[i])) l2.remove(nums1[i]);
        }
//        System.out.println(l);
//        System.out.println(l2);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(l));
        result.add(new ArrayList<>(l2));
        return result;
    }
}
