package net.pack.leetcodestyle.retsotred;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.recoverOrder(new int[]{3, 4, 5, 1}, new int[]{1, 5});
    }

    public int[] recoverOrder(int[] order, int[] friends) {
        List<Integer> list = Arrays.stream(friends).boxed().collect(Collectors.toList());
        int[] arr = new int[friends.length];
        int idx = 0;
        for (int i = 0; i < order.length; i++) {
            if (list.contains(order[i])) {
                arr[idx] = order[i];
                idx++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
