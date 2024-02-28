package net.pack.leetcodestyle.minstepsmakeanagram;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSteps("leetcode", "coats"));
        System.out.println(solution.minSteps("night","thing"));
        System.out.println(solution.minSteps("cotxazilut","nahrrmcchxwrieqqdwdpneitkxgnt"));
    }

    public int minSteps(String s, String t) {
        Map<String, Long> mapS = Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> mapT = Arrays.stream(t.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return sumCounter(mapT, mapS) + sumCounter(mapS, mapT);
    }

    private int sumCounter(Map<String, Long> map1, Map<String, Long> map2) {
        int counter = 0;
        for(Map.Entry<String, Long> p : map1.entrySet()) {
            if(map2.containsKey(p.getKey())) {
                if(map2.get(p.getKey()) > map1.get(p.getKey())) counter += (int) (map2.get(p.getKey()) - p.getValue());
                else counter += (int) (map1.get(p.getKey()) - p.getValue());
            } else {
                for (int i = 0; i < p.getValue(); i++) counter++;
            }
        }
        return counter;
    }
}
