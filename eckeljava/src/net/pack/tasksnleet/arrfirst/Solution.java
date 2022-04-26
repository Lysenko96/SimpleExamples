package net.pack.tasksnleet.arrfirst;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().arrayPairSum(new int[]{6,2,6,5,1,2}));
    }

    public int arrayPairSum(int[] nums) {
        Set<Pair> pairs = new HashSet<>();
        Set<Pair> pairs2 = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if(i != j) {
                    pairs.add(new Pair(new ArrayList<>(Arrays.asList(nums[i], nums[j]))));
                }
            }
        }
        for(Pair pair : pairs){
            Collections.sort(pair.getPair());
            pairs2.add(pair);
        }
        System.out.println(pairs2);

//        List<Pair> pairs2L = new ArrayList<>(pairs2);
//        List<Integer> sums = new ArrayList<>();
//        for(int i = 0; i < pairs2.size(); i++){
//            sums.add(Math.min(pairs2L.get(i).getPair().get(0), pairs2L.get(i).getPair().get(1)));
//        }
//        System.out.println(sums);
//        List<Integer> l = new ArrayList<>();
//        for(int i = 0; i < sums.size()-1; i+=2){
//            l.add(sums.get(i) + sums.get(i + 1));
//        }
      //  System.out.println(l);
        return 0;
    }

}

class Pair {

private List<Integer> pair;

    public Pair(){}

    public Pair(List<Integer> pair) {
        this.pair = pair;
    }

    public List<Integer> getPair() {
        return pair;
    }

    public void setPair(List<Integer> pair) {
        this.pair = pair;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair1 = (Pair) o;
        return Objects.equals(pair, pair1.pair);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pair);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "pair=" + pair +
                '}';
    }
}
