package isprogression;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().canMakeArithmeticProgression(new int[]{3,5,1}));
    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int first = arr[0];
        int second = arr[1];
        int step = 0;
        if(first > second) step = (first - second) * -1;
        else step = second - first;
        //System.out.println(step);
        int counter = 0;
        for(int i = 0; i < arr.length-1; i++){
            int val = first += step;
            if(arr[i + 1] == val){
                counter++;
            }
        }
        return counter == arr.length-1;
    }
}
