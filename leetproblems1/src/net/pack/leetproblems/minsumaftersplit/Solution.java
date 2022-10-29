package net.pack.leetproblems.minsumaftersplit;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumSum(2436));
        System.out.println(new Solution().minimumSum(2932));
        System.out.println(new Solution().minimumSum(4009));
        System.out.println(new Solution().minimumSum(2710));
    }

    public int minimumSum(int num) {
        String[] arrStr = String.valueOf(num).split("");
        int[] arr = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        List<Pair> pairs = new ArrayList<>();
        int[] a = {arr[0], arr[1], arr[2], arr[3]};
        for (int w = 0; w < 4; w++) {
            for (int x = 0; x < 4; x++) {
                for (int y = 0; y < 4; y++) {
                    for (int z = 0; z < 4; z++) {
                        if (w != x && x != y && y != z && z != x) {
                            //System.out.println(a[w] + "" + a[x] + "" + a[y] + "" + a[z]);
                            pairs.add(new Pair(Integer.parseInt(a[w] + "" + a[x]), Integer.parseInt(a[y] + "" + a[z])));
                        }
                    }
                }
            }
        }
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < a.length; i++)
            l.add(a[i]);

        Map<Integer, Long> map = l.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Collections.sort(pairs, Comparator.comparing(Pair::getSum));
        //System.out.println(pairs);
        for (int i = 0; i < pairs.size(); i++) {
            Pair pair = pairs.get(i);
            List<Integer> l2 = new ArrayList<>();
            l2.add(Integer.parseInt(String.valueOf(pair.getOne()).split("")[0]));
            if (String.valueOf(pair.getOne()).split("").length > 1)
                l2.add(Integer.parseInt(String.valueOf(pair.getOne()).split("")[1]));
            l2.add(Integer.parseInt(String.valueOf(pair.getTwo()).split("")[0]));
            if (String.valueOf(pair.getTwo()).split("").length > 1)
                l2.add(Integer.parseInt(String.valueOf(pair.getTwo()).split("")[1]));
            Map<Integer, Long> map2 = l2.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//            System.out.println(map);
//            System.out.println(map2);
//            System.out.println(l2);
            if(l2.contains(0)){
                map2.remove(0);
                map.remove(0);
                if(map.equals(map2)){
                    return pair.getOne() + pair.getTwo();
                }
            }
            else if(map.equals(map2)){
//                if(l2.contains(0)) {
//                //System.out.println(pair);
//                if (String.valueOf(pair.getOne()).contains("0")) {
//                    if (String.valueOf(pair.getOne()).split("")[0].equals("0"))
//                        pair.setOne(Integer.parseInt(String.valueOf(pair.getOne()).split("")[1]));
//                    else if (String.valueOf(pair.getOne()).split("")[1].equals("0"))
//                        pair.setOne(Integer.parseInt(String.valueOf(pair.getOne()).split("")[0]));
//                }
//                //System.out.println(pair);
//                if (String.valueOf(pair.getTwo()).contains("0")) {
//                    if (String.valueOf(pair.getTwo()).split("")[0].equals("0"))
//                        pair.setTwo(Integer.parseInt(String.valueOf(pair.getTwo()).split("")[1]));
//                    else if (String.valueOf(pair.getTwo()).split("")[1].equals("0"))
//                        pair.setTwo(Integer.parseInt(String.valueOf(pair.getTwo()).split("")[0]));
//                }
//                //System.out.println(pair);
//                //pair.setSum(pair.getOne() + pair.getTwo());
//                //System.out.println(pair);
//                return pair.getSum();
//                }
            //System.out.println(pair);
                //System.out.println(Integer.parseInt(l2.get(0) + "" + l2.get(1)) + Integer.parseInt(l2.get(2) + "" + l2.get(3)));
                //return Integer.parseInt(l2.get(0) + "" + l2.get(1)) + Integer.parseInt(l2.get(2) + "" + l2.get(3));
                return pair.getOne() + pair.getTwo();

            }
        }

        //  System.out.println(map);
        return 0;
    }

}

class Pair {

    private int one;
    private int two;
    private int sum;

    public Pair(int one, int two) {
        this.one = one;
        this.two = two;
    }

    public int getOne() {
        return one;
    }

    public void setOne(int one) {
        this.one = one;
    }

    public int getTwo() {
        return two;
    }

    public void setTwo(int two) {
        this.two = two;
    }

    public int getSum() {
        this.sum = one + two;
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return one == pair.one && two == pair.two && sum == pair.sum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(one, two, sum);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "one=" + one +
                ", two=" + two +
                ", sum=" + sum +
                '}';
    }
}