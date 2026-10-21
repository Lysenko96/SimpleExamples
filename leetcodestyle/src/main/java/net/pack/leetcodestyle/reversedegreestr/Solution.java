package reversedegreestr;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    static void main() {
        Solution s = new Solution();
        s.reverseDegree("abc");
        s.reverseDegree("zaza");
    }

    public int reverseDegree(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 'Z'; i >= 'A'; i--) {
            map.put(String.valueOf((char) i).toLowerCase(), Math.abs(i - 'Z' - 1));
        }
        System.out.println(map);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += map.get(s.split("")[i]) * (i + 1);
        }
//        System.out.println(result);
        return result;
    }
}
