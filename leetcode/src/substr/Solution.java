package substr;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countGoodSubstrings("aababcabc"));
    }

    public int countGoodSubstrings(String s) {
        StringBuilder sb = new StringBuilder(s);
        List<String> subStrings = new ArrayList<>();
        while (sb.length() >= 3){
            subStrings.add(sb.substring(0,3));
            sb.deleteCharAt(0);
        }
        //System.out.println(subStrings);
        Map<String, Long> map = new HashMap<>();
        int counter = 0;
        for(String sub : subStrings) {
            map = Arrays.asList(sub.split("")).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            //System.out.println(map);
            if(map.size() == 3) counter++;
        }
        return counter;
    }
}
