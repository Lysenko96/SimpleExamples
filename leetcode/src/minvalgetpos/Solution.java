package minvalgetpos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minStartValue(new int[]{-3, 2, -3, 4, 2}));
    }

    public int minStartValue(int[] nums) {
        int n = 1;
        List<Integer> sums = null;
        while (true) {
            boolean f = false;
            sums = new ArrayList<>();
            //System.out.println(n);
            sums.add(nums[0] + n);
            int res = nums[0] + n;
            for (int i = 1; i < nums.length; i++) {
                res += nums[i];
                sums.add(res);
            }
            //System.out.println(sums);
            for (Integer i : sums) {
                if (i <= 0) {
                    f = true;
                    break;
                }
            }
            if (f) n += 1;
            else {
                break;
            }
        }
        return n;
    }
}
