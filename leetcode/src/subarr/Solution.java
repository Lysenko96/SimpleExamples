package subarr;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().numOfSubarrays(new int[]{2,2,2,2,5,5,5,8}, 3, 4));
    }

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        List<Integer> numbers = new ArrayList<>();
        for (int j : arr) {
            numbers.add(j);
        }
        int result = 0;
        long first  = 0;
        while (first < arr.length - k + 1) {
            int avg = 0;
//            for (int i = first; i < k + first; i++) {
//                avg += numbers.get(i);
//            }
            System.out.println(numbers.stream().skip(first).limit(k + first).collect(Collectors.toList()));
            avg /= k;
            if (avg >= threshold) {
                result++;
            }
            first++;
        }
        return result;
    }
}
