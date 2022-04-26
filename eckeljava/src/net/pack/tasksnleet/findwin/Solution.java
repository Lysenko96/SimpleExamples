package net.pack.tasksnleet.findwin;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        //System.out.println(new Solution().findTheWinner(5,2));
//        int k = 2 - 1;
//        List<Integer> l = new ArrayList<>(Arrays.asList(1,2,3,4,5));
//      int m = 0;
//      int t = 0;
//    while (m < 5){
//        if(k >= 5) {
//            k = k - 5;
//        }
//        System.out.println(l.get(k));
//        t = k;
//        k += 2;
//        System.out.println(l.get(k));
//        l.remove(l.get(t));
//        m++;
//    }
        List<Elem> elems = new ArrayList<>();
    }

    public int findTheWinner(int n, int k) {
//        int[] arr = new int[n];
//        for(int i = 0; i < arr.length; i++){
//            arr[i] = i + 1;
//        }
//        System.out.println(Arrays.toString(arr));
//        int z = k - 1;
//        int m = 0;
//       while(m < n){
//           if(z < n) {
//               System.out.println(z);
//           } else {
////               z -= n;
//               System.out.println(z);
//           }
//           m++;
//           z += k;
//
//       }
//        for(int i = 0; i < arr.length; i++){
//            if(arr[i] != 0){
//                System.out.println(arr[i]);
//            }
//        }
        return 0;
    }
}

class Elem {

    int value;
    boolean check;

    public Elem(){}

    public Elem(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
