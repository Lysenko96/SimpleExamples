package net.pack.leetcodestyle.intervallistintersections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Memory Limit Exceeded

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.intervalIntersection(new int[][]{{0, 2}, {5, 10}}, new int[][]{{1, 5}, {8, 12}})));
        System.out.println(Arrays.deepToString(solution.intervalIntersection(new int[][]{{0, 2}, {5, 10}}, new int[][]{})));
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) return new int[][]{};
        List<List<Integer>> intervalsFirstList = getIntervals(firstList);
        List<List<Integer>> intervalsSecondList = getIntervals(secondList);
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> first : intervalsFirstList) {
            for (List<Integer> second : intervalsSecondList) {
                if (second.contains(first.get(0)) || second.contains(first.get(first.size() - 1)) ||
                        first.contains(second.get(0)) || first.contains(second.get(second.size() - 1))) {
                    List<Integer> intervalIntersection = first.stream()
                            .filter(second::contains)
                            .collect(Collectors.toList());
                    intervalIntersection = List.of(intervalIntersection.get(0), intervalIntersection.get(intervalIntersection.size() - 1));
                    result.add(intervalIntersection);
                }
            }
        }
        int[][] resultArr = new int[result.size()][2];
//        System.out.println(result);
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < 2; j++) {
                resultArr[i][j] = result.get(i).get(j);
            }
        }
//        System.out.println(Arrays.deepToString(resultArr));
        return resultArr;
    }

    private List<List<Integer>> getIntervals(int[][] list) {
        List<List<Integer>> intervalsList = new ArrayList<>();
        for (int[] subInterval : list) {
            List<Integer> interval = new ArrayList<>();
            for (int number : subInterval) {
                interval.add(number);
            }
            interval = Stream.iterate(interval.get(0), e -> e + 1)
                    .limit((interval.get(interval.size() - 1) - interval.get(0)) + 1)
                    .collect(Collectors.toList());
            if (!interval.isEmpty()) intervalsList.add(interval);
        }
        return intervalsList;
    }
}
