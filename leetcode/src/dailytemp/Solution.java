package dailytemp;

import java.util.*;

class Solution {

    public static void main(String[] args) {
         System.out.println(Arrays.toString(new Solution().dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
        //System.out.println(Arrays.deepToString(new Solution().getMatrix(6)));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int count = 0;
        for (int i = 0; i < temperatures.length - 1; i++) {
            if (temperatures[i + 1] > temperatures[i]) {
                System.out.println(temperatures[i] + " < " + temperatures[i + 1]);
                count = 0;
            } else {
                count++;
                System.out.println(count);
            }
        }
        return null;
    }

    public int[][] getMatrix(int size) {
        int[][] arr = new int[size][size];
        List<Integer> l = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        int p = 1;
        int c = 0;
        for (int i = 0; i < size * size; i++) {
            l.add(p++);
        }
        while (l1.size() != size * size){
            int v = l.get(new Random().nextInt(l.size()));
            if(!l1.contains(v)) {
                l1.add(v);
            }
        }
        //System.out.println(l1);
        //System.out.println(l.size());
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                arr[i][j] = l1.get(c);
                c++;
            }
        }
        Set<Integer> set = new HashSet<>(l1);
        System.out.println(set.size());
        return arr;
    }
}
