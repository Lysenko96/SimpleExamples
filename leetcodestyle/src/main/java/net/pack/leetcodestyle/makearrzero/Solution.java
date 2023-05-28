package net.pack.leetcodestyle.makearrzero;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumOperations(new int[]{1, 5, 0, 3, 5}));
        System.out.println(new Solution().minimumOperations(new int[]{ 0}));
        System.out.println(new Solution().minimumOperations(new int[]{ 1}));
    }

    public int minimumOperations(int[] nums) {
        List<Integer> l = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int counter = 0;
        if (new HashSet<>(l).size() == 1 && !l.contains(0)) return 1;
        while (new HashSet<>(l).size() > 1) {
            int min = l.stream().filter(e -> e > 0).min(Comparator.naturalOrder()).get();
            //System.out.println(min);
            List<Integer> update = new ArrayList<>();
            Iterator<Integer> it = l.iterator();
            while (it.hasNext()) {
                Integer res = it.next();
                if (res > 0) {
                    res -= min;
                }
                //System.out.print(res);
                update.add(res);
            }
            //System.out.println();
            l = update;
            counter++;
        }
        return counter;
    }
}
