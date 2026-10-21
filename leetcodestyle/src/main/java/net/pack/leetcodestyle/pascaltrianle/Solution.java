package net.pack.leetcodestyle.pascaltrianle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generate(3));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1))
        ));
        if (numRows == 1) {
            return result;
        }
        result.add(new ArrayList<>(Arrays.asList(1, 1)));
        if (numRows == 2) {
            return result;
        }

        List<Integer> line = new ArrayList<>(Arrays.asList(1, 1));
        for (int k = 0; k < numRows - 2; k++) {
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
        return result;
    }
}
