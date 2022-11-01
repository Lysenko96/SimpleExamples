package net.pack.leetproblems.numbertriplets;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution {


    public static void main(String[] args) {
        System.out.println(new Solution().arithmeticTriplets(new int[]{0,1,4,6,7,10}, 3));
    }

    public int arithmeticTriplets(int[] nums, int diff) {
        Set<Triplet> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                for(int k = 0; k < nums.length; k++){
                    if(i < j && j < k){
                        if(nums[j] - nums[i] == diff && nums[k] - nums[j] == diff){
                            set.add(new Triplet(i,j,k));
                        }
                    }
                }
            }
        }
        return set.size();
    }
}

class Triplet {

    private int i;
    private int j;
    private int k;

    Triplet(){}

    public Triplet(int i, int j, int k) {
        this.i = i;
        this.j = j;
        this.k = k;
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

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triplet)) return false;
        Triplet triplet = (Triplet) o;
        return i == triplet.i && j == triplet.j && k == triplet.k;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j, k);
    }

    @Override
    public String toString() {
        return "Triplet{" +
                "i=" + i +
                ", j=" + j +
                ", k=" + k +
                '}';
    }
}
