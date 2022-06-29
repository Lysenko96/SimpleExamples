package sortbypowerval;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getKth(7,11, 4));
    }

    public int getKth(int lo, int hi, int k) {
        List<Integer> digits = new ArrayList<>();
        List<Integer> powers = new ArrayList<>();
        for(int i = lo; i <= hi; i++){
            digits.add(i);
        }
        //System.out.println(digits);
        for(Integer i : digits){
            powers.add(calc(i));
        }
        //System.out.println(powers);
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> mapSort = new HashMap<>();
        for(int i = 0; i < powers.size(); i++){
          map.put(digits.get(i), powers.get(i));
        }
        //System.out.println(map);
        List<Map.Entry<Integer, Integer>> entrySet = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).toList();
        //System.out.println(entrySet);
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(entrySet);
        List<Map.Entry<Integer, Integer>> entryListSort = new ArrayList<>();
        entryListSort = entryList.stream().sorted(Map.Entry.comparingByKey()).sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
        //System.out.println(entryListSort);
        //System.out.println(entryListSort.get(k-1).getKey());
        return entryListSort.get(k-1).getKey();
    }

    public int calc(int digit){
        //System.out.println(digit);
        int counter = 0;
        while (digit > 1){
            if(digit % 2 != 0){
                digit = digit *  3 + 1;
            } else {
                digit /= 2;
            }
            //System.out.println(digit);
            counter++;
        }
        return  counter;
    }
}
