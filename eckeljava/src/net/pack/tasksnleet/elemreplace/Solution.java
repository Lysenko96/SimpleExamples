package net.pack.tasksnleet.elemreplace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(new Solution().replaceElements(new int[]{17, 18, 5, 4, 6, 1})));
        System.out.println(Arrays.toString(new Solution().replaceElements(new int[]{57010, 40840, 69871, 14425, 70605})));

    }

    public int[] replaceElements(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }
        List<Integer> list = new ArrayList<>();
        for (Integer i : arr) {
            list.add(i);
        }

        List<Integer> result = new ArrayList<>();
        List<Integer> indexies = new ArrayList<>();
        List<Integer> correctList = new ArrayList<>();
        int[] correctArr = new int[]{};
        int max = Collections.max(list);
       // System.out.println(max);
        int indexV = getIndexByValue(list, max);
        result.add(max);
     //   System.out.println(indexV);
        indexies.add(indexV);
     //   System.out.println(list);
        int pref = 1;
        if (indexV == list.size() - 1) {
            int maxV = Collections.max(list);
            correctArr = new int[list.size()];
            for(int i = 0; i < correctArr.length-1; i++){
                correctArr[i] = maxV;
            }
            correctArr[list.size()-1] = -1;
        } else {
            while (true) {
                max = getMaxWithoutValueAfterIndex(list, max);
                result.add(max);
             //   System.out.println(max);
                indexV = getIndexByValue(list, max);
           //     System.out.println(indexV);
                indexies.add(indexV + pref);
                pref++;
              //  System.out.println(list);
                if (list.size() - 1 == indexV) {
                    break;
                }
            }

            Collections.sort(result);
            Collections.reverse(result);
          //  System.out.println(indexies);

          //  System.out.println(result);
            int begin = 0;
            int count = 0;
            for (int j = 0; j < indexies.size(); j++) {
                for (int i = begin; i < indexies.get(j); i++) {
                    correctList.add(result.get(count));
                }
                begin = indexies.get(j);
                count++;
            }
            correctList.add(-1);
          //  System.out.println(correctList);
            correctArr = new int[correctList.size()];
            for (int i = 0; i < correctArr.length; i++) {
                correctArr[i] = correctList.get(i);
            }
        }
        return correctArr;
    }

    public int getIndexByValue(List<Integer> list, int value) {
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(value)) {
                index = i;
            }
        }
        return index;

    }

    public int getMaxWithoutValueAfterIndex(List<Integer> list, int value) {
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(value)) {
                index = i;
            }
        }
        list.remove(list.get(index));
        List<Integer> l = new ArrayList<>();
        for (int i = index; i < list.size(); i++) {
            l.add(list.get(i));
        }
        return Collections.max(l);
    }

}
