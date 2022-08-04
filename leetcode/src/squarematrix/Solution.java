package squarematrix;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().checkXMatrix(new int[][]{{2,0,0,1},{0,3,1,0},{0,5,2,0},{4,0,0,2}}));
       // System.out.println(new Solution().checkXMatrix(new int[][]{{0,0,0,0,1}, {0,4,0,1,0},{0,0,5,0,0},{0,5,0,2,0},{4,0,0,0,2}}));
       // System.out.println(new Solution().checkXMatrix(new int[][]{{5,0,0,1},{0,4,1,5},{0,5,2,0},{4,1,0,2}}));
    }

    public boolean checkXMatrix(int[][] grid) {
//        System.out.println(grid.length);
        Set<Integer> set = new HashSet<>();
        Set<Pair> pairs = new HashSet<>();
        Set<Pair> all = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid.length; j++){
                if(i == j) {
                    pairs.add(new Pair(i, j));
                    set2.add(grid[i][j]);
                }
                    //System.out.println(grid[i][j]);
                all.add(new Pair(i,j));
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        int val = grid.length-1;
        for(int i = 0; i < grid.length; i++){
            //System.out.println(grid[val][i]);
            set2.add(grid[val][i]);
            pairs.add(new Pair(val,i));
            val--;
        }
        //System.out.println(pairs);
        //System.out.println(all);
        List<Pair> res = all.stream().filter(p -> !pairs.contains(p)).toList();
        //System.out.println(res);
        for(Pair p : res){
            //System.out.println(grid[p.getX()][p.getY()]);
            set.add(grid[p.getX()][p.getY()]);
        }
//        System.out.println(set.size());
//        System.out.println(new ArrayList<>(set).get(0).equals(0));
//        System.out.println(new ArrayList<>(set2));
        return set.size() == 1 && new ArrayList<>(set).get(0).equals(0) && !new ArrayList<>(set2).contains(0);
    }
}

class Pair {

    private int x;
    private int y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false;
        Pair pair = (Pair) o;
        return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
