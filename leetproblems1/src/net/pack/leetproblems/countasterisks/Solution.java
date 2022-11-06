package net.pack.leetproblems.countasterisks;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().countAsterisks("|**|*|*|**||***||"));
    }

    public int countAsterisks(String s) {
        int result = 0;
        String[] arr = s.split("\\|");
        int count = 0;
        //System.out.println(Arrays.asList(arr));
        for(String line : arr){
            if(count % 2 == 0){
                //System.out.println(line);
                for(String letter : line.split("")){
                    //System.out.println(letter);
                    if(letter.equals("*")){
                        result++;
                        //System.out.println(result);
                    }
                }
            }
            count++;
        }
        return result;
    }
}
