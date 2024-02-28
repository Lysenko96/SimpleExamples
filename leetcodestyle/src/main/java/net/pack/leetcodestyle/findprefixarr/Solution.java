package net.pack.leetcodestyle.findprefixarr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        new Solution().findThePrefixCommonArray(new int[]{1,3,2,4},new int[]{3,1,2,4});
        new Solution().findThePrefixCommonArray(new int[]{2,3,1},new int[]{3,1,2});
    }

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        List<Integer> list = new ArrayList<>();
        int[] result = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            list.add(A[i]);
            list.add(B[i]);
            Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            result[i] = (int) map.entrySet().stream().filter(e -> e.getValue() > 1).count();
        }
        //System.out.println(Arrays.toString(result));
        return result;
    }
}
