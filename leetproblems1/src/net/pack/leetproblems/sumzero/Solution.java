package net.pack.leetproblems.sumzero;

public class Solution {

    public static void main(String[] args) {
        new Solution().sumZero(5);
    }

    public int[] sumZero(int n) {
            if(n == 1){
                return new int[]{0};
            }
            int[] arr = new int[n];
            arr[0] = -n;
            int sum = -n;
            for(int i = 1; i < n-1; i++){
                arr[i] = i;
                sum += i;
            }
            arr[n-1] = -sum;
            return arr;
    }
//        int[] arr = new int[n];
//        int val = 1;
//        Set<Integer> set = new HashSet<>();
//        while (val != 0 && set.size() != n) {
//            val = 0;
//            set = new HashSet<>();
//            for (int i = 0; i < n; i++) {
//                int res = (int) Math.floor(Math.random() * (n - (-n) + 1) + (-n));
//                set.add(res);
//            }
//            for(Integer i : set){
//                val += i;
//            }
//        }
//        System.out.println(set);
//        return arr;
//    }
}
