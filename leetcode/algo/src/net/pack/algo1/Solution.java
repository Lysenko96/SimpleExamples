package net.pack.algo1;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().hammingDistance(1,3));
    }

    public int hammingDistance(int x, int y) {
        String x1 = Integer.toString(x, 2);
        String y1 = Integer.toString(y, 2);
        List<Integer> digitsX = new ArrayList<>();
        List<Integer> digitsY = new ArrayList<>();
        if(x1.length() > y1.length()){
            for(int i = 0; i < x1.length() - y1.length(); i++){
                digitsY.add(0);
            }
        } else if(y1.length() > x1.length()){
            for(int i = 0; i < y1.length() - x1.length(); i++){
                digitsX.add(0);
            }
        }
        for(String n : x1.split("")){
            digitsX.add(Integer.parseInt(n));
        }
        for(String n : y1.split("")){
            digitsY.add(Integer.parseInt(n));
        }
        System.out.println(digitsX);
        System.out.println(digitsY);
        int count = 0;
        for(int i =0; i < digitsX.size(); i++){
            if(!digitsX.get(i).equals(digitsY.get(i))){
                count++;
            }
        }
        return count;
    }
}
