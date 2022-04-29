package net.pack.tasksnleet.weakestrows;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().kWeakestRows(new int[][]{{1, 0}, {1, 0}, {1,  0}, {1, 1}}, 4)));
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        List<Line> lines = new ArrayList<>();
        List<Integer> rows = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int j = 0; j < mat[i].length; j++) {
                sum += mat[i][j];
            }
            //System.out.println(new Line(sum, i));
            lines.add(new Line(sum,i));
        }
        Collections.sort(lines, Comparator.comparing(Line::getSum));
        for(int i = 0; i < lines.size(); i++) {
            rows.add(lines.get(i).getRow());
        }
        int[] arr = new int[k];
        for(int i = 0; i < k; i++){
            arr[i] = rows.get(i);
        }
        return arr;
    }
}

class Line {

    private int sum;
    private int row;

    public Line(int sum, int row) {
        this.sum = sum;
        this.row = row;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return sum == line.sum && row == line.row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sum, row);
    }

    @Override
    public String toString() {
        return "Line{" +
                "sum=" + sum +
                ", row=" + row +
                '}';
    }
}