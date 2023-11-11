package net.pack.leetcodestyle.buildarr;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
//        new Solution().buildArray(new int[]{1,3}, 3);
//        new Solution().buildArray(new int[]{1,2,3}, 3);
//        new Solution().buildArray(new int[]{1,2}, 4);
        new Solution().buildArray(new int[]{3,4,5}, 4);
    }

    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        List<Integer> targetList = new ArrayList<>();
        int counter = 0;
        if(target[0] == 1) {
            result.add("Push");
        } else if(target[0] > 1) {
            for(int i = 0; i < target[0]-1; i++) {
                result.add("Push");
                result.add("Pop");
            }
            result.add("Push");
        }
        for (int i = 0; i < target.length-1; i++) {
            int diff = target[i + 1] - target[i];
            //System.out.println(diff);
            if (diff == 1) {
                result.add("Push");
                counter++;
                targetList.add(counter);
            } else if (diff > 1) {
                for (int j = 0; j < diff - 1; j++) {
                    result.add("Push");
                    result.add("Pop");
                    counter++;
                }
                result.add("Push");
                counter++;
                targetList.add(counter);
            }
        }
//        System.out.println(result);
//        System.out.println(targetList);
        return result;
    }

}

