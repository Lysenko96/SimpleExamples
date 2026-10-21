package net.pack.leetcodestyle.stockprofit;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit(new int[]{2, 4, 1}));
//        System.out.println(solution.maxProfit(new int[]{1, 2}));
//        System.out.println(solution.maxProfit(new int[]{3,2,6,5,0,3}));
    }

    public int maxProfit(int[] prices) {
        List<Integer> reversed = Arrays.stream(prices).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Integer> input = Arrays.stream(prices).boxed().collect(Collectors.toList());
        if (reversed.equals(input)) {
            return 0;
        }
        List<Integer> stocks = new ArrayList<>();
        return stocks.isEmpty() ? 0 : Collections.max(stocks);
    }
}
