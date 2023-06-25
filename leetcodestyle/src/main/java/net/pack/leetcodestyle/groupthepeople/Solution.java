package net.pack.leetcodestyle.groupthepeople;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        //System.out.println(new Solution().groupThePeople(new int[]{4, 4, 3, 5, 3, 3}));
        System.out.println(new Solution().groupThePeople(new int[]{ 3, 3, 3, 3, 3, 1, 3, 6, 6, 6, 6, 6, 6,}));
        // System.out.println(new Solution().groupThePeople(new int[]{3, 3, 3, 3, 5, 3, 3, 2, 2, 2, 2, 1, 1, 1, 1, 1}));
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, Long> map = IntStream.of(groupSizes).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //System.out.println(map);
        Set<Integer> groupRepeat = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        //int counter = 0;
        for (Map.Entry<Integer, Long> pair : map.entrySet()) {
            if (pair.getValue() > pair.getKey()) {
                //counter += pair.getValue() / pair.getKey();
                groupRepeat.add(pair.getKey());
            } //else {
            //counter++;
            // }
        }
//        System.out.println(counter);
//        System.out.println(groupRepeat);
        if (groupRepeat.isEmpty()) {
            result = getGroupWithoutRepeat(map, groupSizes);
            //System.out.println(result);
            return result;
        } else {
            List<List<Integer>> subResult = getGroupWithoutRepeat(map, groupSizes);
            List<List<Integer>> normal = new ArrayList<>();
            List<List<Integer>> repeat = new ArrayList<>();
            for (List<Integer> list : subResult) {
                if (groupSizes[list.get(0)] != list.size()) {
                    repeat.add(list);
                } else {
                    normal.add(list);
                }
            }
//            System.out.println(normal);
//            System.out.println(repeat);
//            System.out.println(subResult);
            result = getGroupWithRepeat(groupRepeat, repeat);
            result.addAll(normal);
            return result;
        }
    }

    List<List<Integer>> getGroupWithoutRepeat(Map<Integer, Long> map, int[] groupSizes) {
        Set<Integer> keys = map.keySet();
        List<List<Integer>> result = new ArrayList<>();
        for (Integer key : keys) {
            List<Integer> group = new ArrayList<>();
            for (int i = 0; i < groupSizes.length; i++) {
                if (groupSizes[i] == key) {
                    group.add(i);
                }
            }
            result.add(group);
        }
        return result;
    }

    List<List<Integer>> getGroupWithRepeat(Set<Integer> groupRepeat, List<List<Integer>> result) {
        List<List<Integer>> newResult = new ArrayList<>();
        List<Integer> listGroupRepeat = new ArrayList<>(groupRepeat);
        for (int i = 0; i < groupRepeat.size(); i++) {
//            System.out.println(listGroupRepeat.get(i));
//            System.out.println(result.get(i));
            int val = 0;
            int next = listGroupRepeat.get(i);
            for (int j = 0; j < result.get(i).size() / listGroupRepeat.get(i); j++) {
                List<Integer> newGroup = result.get(i).subList(val, next);
                val += listGroupRepeat.get(i);
                next += listGroupRepeat.get(i);
                // System.out.println(newGroup);
                newResult.add(newGroup);
            }
        }
        //System.out.println(newResult);
//        for (int i = groupRepeat.size(); i < result.size(); i++) {
//            newResult.add(result.get(i));
//        }
        return newResult;
    }

}
