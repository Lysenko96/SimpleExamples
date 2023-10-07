package net.pack.leetcodestyle.sortedkscore;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        new Solution().sortTheStudents(new int[][]{{10,6,9,1},{7,5,11,2},{4,8,3,15}}, 2);
    }

    public int[][] sortTheStudents(int[][] score, int k) {
        Map<Integer, List<Integer>> table = new HashMap<>();
        for(int i = 0; i < score.length; i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j < score[i].length; j++) {
                row.add(score[i][j]);
            }
            table.put(score[i][k], row);
        }
        //System.out.println(table);
        List<List<Integer>> result = new ArrayList<>();
        table.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).forEach(e -> result.add(e.getValue()));
        //System.out.println(result);
        List<Integer>  matrixList = result.stream().flatMap(Collection::stream).collect(Collectors.toList());
        int index = 0;
        for(int i = 0; i < score.length; i++){
            for(int j = 0; j < score[i].length; j++) {
                score[i][j] = matrixList.get(index);
                index++;
            }
        }
        //System.out.println(Arrays.deepToString(score));
        return score;
    }
}
