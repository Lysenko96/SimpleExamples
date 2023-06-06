package net.pack.leetcodestyle.sumevenafterqueries;

import java.util.Arrays;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sumEvenAfterQueries(new int[]{1, 2, 3, 4},
                new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}})));
    }

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] arr = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            nums[queries[i][1]] += queries[i][0];
            arr[i] = Stream.of(nums).flatMapToInt(Arrays::stream).filter(n -> n % 2 == 0).sum();
        }
        return arr;
    }
}
