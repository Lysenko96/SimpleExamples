package net.pack.leetcodestyle.pairssumlesstarget;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().countPairs(Arrays.asList(-1,1,2,3,1),2));
        System.out.println(new Solution().countPairs(Arrays.asList(-6,2,5,-2,-7,-1,3),-2));
        System.out.println(new Solution().countPairs(Arrays.asList(9,-5,-5,5,-5,-4,-6,6,-6),3));
    }

    public int countPairs(List<Integer> nums, int target) {
        int counter = 0;
        for(int i = 0; i < nums.size(); i++){
            for(int j = 0; j < nums.size(); j++){
                if(i==j) continue;
                Pair pair = new Pair(nums.get(i), nums.get(j));
                if(pair.getSum() < target) {
                    counter++;
                }
            }
        }
      //  System.out.println(pairs);
        return counter / 2;
    }
}

class Pair {

    private int i;
    private int j;

    public Pair() {
    }

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getSum(){
        return i + j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        if (i != pair.i) return false;
        return j == pair.j;
    }

    @Override
    public int hashCode() {
        int result = i;
        result = 31 * result + j;
        return result;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }
}
