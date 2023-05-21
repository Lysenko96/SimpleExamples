package net.pack.leetcodestyle.queriespermutation;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(new Solution().processQueries(new int[]{3, 1, 2, 1}, 5)));
        System.out.println(Arrays.toString(new Solution().processQueries(new int[]{4, 1, 2, 2}, 4)));
    }

    public int[] processQueries(int[] queries, int m) {
        List<Integer> permutations = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            permutations.add(i);
        }
//        System.out.println(Arrays.toString(queries));
//        System.out.println(permutations);
        List<Integer> clone = new ArrayList<>(permutations);
        for(Integer query : queries){
            int index = 0;
            Iterator<Integer> it = permutations.iterator();
            int i = 0;
            while (it.hasNext()){
                Integer next = it.next();
                if(next.equals(query)){
                    it.remove();
                    //System.out.println(i);
                    result.add(i);
                    index = i;
                }
                i++;
            }
            //System.out.println(permutations);
            permutations.add(0, clone.get(index));
            //System.out.println(permutations.subList(0, 5));
            clone = new ArrayList<>(permutations);
            //break;
        }
//        System.out.println(permutations);
//        permutations.add(0, clone.get(index));
//        System.out.println(permutations.subList(0, 5));
        int[] resultArr = new int[queries.length];
        for(int i = 0; i < result.size(); i++){
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }
}
