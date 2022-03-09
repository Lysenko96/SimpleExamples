package net.pack.minsum;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumSum(4009));
    }

    public int minimumSum(int num) {
        List<Integer> digits = getDigits(num);
        Set<Pair> pairs = new HashSet<>();
        Set<Integer> digits2 = new HashSet<>();
        System.out.println(digits);
        Map<Integer, Long> map = new HashMap<>();
        Map<Integer, Long> map2 = new HashMap<>();
        Map<Integer, Long> map3 = new HashMap<>();
        Map<Integer, Long> map4 = new HashMap<>();
        map = digits.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(map);
        for (int i = 0; i < digits.size(); i++) {
            for (int j = 0; j < digits.size(); j++) {
                if (i != j) {
                    digits2.add(digits.get(j) * 10 + digits.get(i));
                }
            }
        }
        System.out.println(digits2);
        List<Integer> digits2List = new ArrayList<>(digits2);
        for (int i = 0; i < digits2.size(); i++) {
            for (int j = 0; j < digits2.size(); j++) {

                //if (i != j) {
                    new Pair(digits2List.get(i), digits2List.get(j));
                    map2 = getDigits(digits2List.get(i)).stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
                    map3 = getDigits(digits2List.get(j)).stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));
                    for(Map.Entry<Integer, Long> pair : map3.entrySet()){
                        if(map2.containsKey(pair.getKey())){
                            for(Map.Entry<Integer, Long > pairMap2 : map2.entrySet()){
                                map2.put(pair.getKey(), pair.getValue() + pairMap2.getValue());
                            }
                        } else {
                            map2.put(pair.getKey(), pair.getValue());
                        }
                    }
                //}
                System.out.println("m2: " + map2);
                System.out.println("m" + map);
                if(map.equals(map2)){
                    pairs.add(new Pair(digits2List.get(i), digits2List.get(j)));
                }
                for(Map.Entry<Integer, Long> pairMap2 : map2.entrySet()){
                    for(Map.Entry<Integer, Long> pairMap : map.entrySet()){
                        if(pairMap.getKey().equals(pairMap2.getKey()) && pairMap2.getValue() <= pairMap.getValue()){
                            pairs.add(new Pair(digits2List.get(i), digits2List.get(j)));
                        }
                    }
                }
            }
        }
        System.out.println(pairs);
        List<Integer> sums = new ArrayList<>();
        for (Pair pair : pairs) {
            sums.add(pair.x + pair.y);
        }
        int min = Collections.min(sums);
        System.out.println(min);
        return min;
    }

    private List<Integer> getDigits(int num) {
        List<Integer> digits = new ArrayList<>();
        while (num > 0) {
            int value = num % 10;
            digits.add(value);
            num /= 10;
        }
        Collections.reverse(digits);
        return digits;
    }

    class Pair {
        int x;
        int y;

        Pair() {
        }

        Pair(int x, int y) {
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
            if (o == null || getClass() != o.getClass()) return false;
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
}
