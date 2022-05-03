package net.pack.tasksnleet.abeforeb;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().checkString("babb"));
    }

    public boolean checkString(String s) {
        String[] arr = s.split("");
        int countArr = 0;
        int countA = 0;
        for(String w : arr){
            if(w.equals("a")){
                countA++;
            }
        }
        if(countA == 0){
            return true;
        }
        for(int i = 0; i < countA; i++){
            if(arr[i].equals("a")){
                countArr++;
            }
        }
        return countA == countArr;
    }
}
