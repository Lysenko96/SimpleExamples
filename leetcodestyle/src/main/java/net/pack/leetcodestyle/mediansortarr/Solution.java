package net.pack.leetcodestyle.mediansortarr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMedianSortedArrays(new int[]{5, 7}, new int[]{6}));
        System.out.println(s.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length + nums2.length; i++) {
            if (i < nums1.length) {
                list.add(nums1[i]);
            }
            if (i < nums2.length) {
                list.add(nums2[i]);
            }
        }
        Collections.sort(list);
        int size = list.size();
        if (size % 2 != 0) {
            return list.get(size / 2);
        } else {
            int res = size / 2;
            double a = list.get(res);
            double b = list.get(res - 1);
            return (a + b) / 2;
        }
    }
}
