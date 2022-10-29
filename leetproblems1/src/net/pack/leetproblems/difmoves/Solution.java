package net.pack.leetproblems.difmoves;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().minMovesToSeat(new int[]{12,14,19,19,12}, new int[]{19,2,17,20,7}));
    }

    public int minMovesToSeat(int[] seats, int[] students){
        List<Integer> seatsL = new ArrayList<>();
        List<Integer> studL = new ArrayList<>();
        for(int i = 0; i < seats.length; i++){
            seatsL.add(seats[i]);
            studL.add(students[i]);
        }
        Collections.sort(seatsL);
        Collections.sort(studL);
        System.out.println(seatsL);
        System.out.println(studL);
        List<Integer> count = new ArrayList<>();
        for(int i = 0; i < seats.length; i++){
            count.add(studL.get(i)-seatsL.get(i));
        }
        int res = 0;
        for(Integer i : count){
            res += Math.abs(i);
        }
        return res;
    }
    //2-12=-10, 7-12=-5, 17-14=3, 19-19=0 20-19=1 =
}
