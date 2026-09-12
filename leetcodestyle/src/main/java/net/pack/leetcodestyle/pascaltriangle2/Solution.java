package net.pack.leetcodestyle.pascaltriangle2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getRow(3));
    }

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1))
        ));
        if (rowIndex == 0) {
            return result.get(0);
        }
        result.add(new ArrayList<>(Arrays.asList(1, 1)));
        if (rowIndex == 1) {
            return result.get(1);
        }
        List<Integer> line = new ArrayList<>(Arrays.asList(1, 1));
        for (int k = 0; k < rowIndex; k++) {
            List<Integer> newRow = new ArrayList<>();
            for (int i = 0; i < line.size() - 1; i++) {
                int j = i + 1;
                if (j <= line.size() - 1) {
                    int res = line.get(i) + line.get(j);
                    newRow.add(res);
                }
            }
            newRow.add(0, 1);
            newRow.add(1);
            line = newRow;
            result.add(line);
        }
        return result.get(rowIndex);
    }
}
