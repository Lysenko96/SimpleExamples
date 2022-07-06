package sortarr;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().relativeSortArray(new int[]{28,6,6,22,8,44,17,33}, new int[]{22,28,8,6})));
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> sort = new ArrayList<>();
        for(Integer i : arr2){
            sort.add(i);
        }
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        List<Integer> third = new ArrayList<>();
        for(int i = 0; i < arr1.length; i++){
            if(sort.contains(arr1[i]))
                first.add(arr1[i]);
            else
                third.add(arr1[i]);
        }
       // System.out.println(first);
        for(Integer i : arr2){
            for(int j = 0; j < first.size(); j++){
                if(i.equals(first.get(j)))
                    second.add(first.get(j));
            }
        }
        //System.out.println(second);
        Collections.sort(third);
        //System.out.println(third);
        for(Integer i : third)
            second.add(i);

        int[] arr = new int[second.size()];
        for(int i = 0; i < second.size(); i++)
            arr[i] = second.get(i);
        return arr;
    }
}
