package net.pack.tasksnleet.nextgreater;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().nextGreaterElement(new int[]{2,4}, new int[]{1,2,3,4})));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
//                System.out.println(nums1[i]);
//                System.out.println(nums2[j]);
                if(nums1[i] == nums2[j]){
                    //System.out.println(j);
                    l.add(j);
                }
            }
        }
      //  System.out.println(l);

        List<Integer> r1 = new ArrayList<>();
        List<Integer> all = new ArrayList<>();
        for(int j = 0; j < l.size(); j++) {
            //System.out.println(nums2[l.get(j)]);
            List<Integer> r = new ArrayList<>();
            int val = nums2[l.get(j)];
         //   System.out.println(val);
            for (int i = l.get(j); i < nums2.length; i++) {
                if(nums2[i] > val) {
                  //  System.out.println(nums2[i]);
                    r.add(nums2[i]);
                    break;
                }
            }
          //  System.out.println(r);
            if(r.isEmpty()){
                all.add(-1);
            } else {
                all.add(r.get(0));
            }
           // System.out.println();
        }

       // System.out.println(all);
        int[] arrInt = new int[all.size()];
        for(int k = 0; k < arrInt.length; k++){
            arrInt[k] = all.get(k);
        }
        return arrInt;
    }
}
