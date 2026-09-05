package net.pack.leetcodestyle.mergesortarr;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        solution.merge(new int[]{1}, 1, new int[]{1}, 0);
        solution.merge(new int[]{0}, 0, new int[]{1}, 1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 1) {
            int[] nums = new int[m + n];
            for (int i = 0; i < n + m; i++) {
                if (i < m) {
                    nums[i] = nums1[i];
                } else {
                    nums[i] = 0;
                }
            }
            int start = m;
            for (int i = 0; i < n; i++) {
                nums[start] = nums2[i];
                start++;
            }
            nums = Arrays.stream(nums).sorted().toArray();
            System.arraycopy(nums, 0, nums1, 0, nums.length);
        } else if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums2.length);
        } else {
            int nums[] = new int[n + m];
            for (int i = m; i < n + m; i++) {
                nums1[i] = 0;
            }
            System.arraycopy(nums1, 0, nums, 0, m);
            int start = m;
            for (int i = 0; i < n; i++) {
                nums[start] = nums2[i];
                start++;
            }
            nums = Arrays.stream(nums).sorted().toArray();
            System.arraycopy(nums, 0, nums1, 0, nums.length);
        }
        System.out.println(Arrays.toString(nums1));
    }
}
