package net.pack.leetcodestyle.restorearrfrompairs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

// error order
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.restoreArray(new int[][]{{2,1},{3,4},{3,2}})));
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        return Stream.of(adjacentPairs)
                .flatMap(x -> Arrays.stream(x).boxed())
                .mapToInt(Integer::intValue)
                .distinct()
                .toArray();
    }
}
