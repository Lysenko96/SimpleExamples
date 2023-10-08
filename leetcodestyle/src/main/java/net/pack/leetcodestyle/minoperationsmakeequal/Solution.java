package net.pack.leetcodestyle.minoperationsmakeequal;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        //Testcases passed, but took too long.
        System.out.println(new Solution().minOperations(10000));
    }

    public int minOperations(int n) {
        int counter = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = 2 * i + 1;

        while (!Arrays.stream(arr).allMatch(e -> e == n)) {
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
            while (leftIndex < rightIndex) {
                if (arr[leftIndex] == n) break;
                if (arr[rightIndex] == n) break;
                else if (arr[leftIndex] < n) {
                    arr[leftIndex]++;
                    counter++;
                }
                if (arr[rightIndex] > n) {
                    arr[rightIndex]--;
                    counter++;
                }
                leftIndex++;
                rightIndex--;
            }
        }
        return counter / 2;
    }
}
