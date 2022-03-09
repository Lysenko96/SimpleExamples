package net.pack.laserbank;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfBeams(new String[]{"001", "000", "111", "000", "100"}));
    }

    public int numberOfBeams(String[] bank) {
        int result = 0;
        List<String> noZeroList = new ArrayList<>();
        for(String line : bank){
            int count = 0;
            for(String cell : line.split("")){
                if(cell.equals("0")){
                  count++;
                }
            }
            if(count != line.length()){
                noZeroList.add(line);
            }
        }
       // System.out.println(noZeroList);
        List<Integer> lines = new ArrayList<>();
        if(noZeroList.size() == 1){
            result = 0;
        } else {
            for(int i = 0; i < noZeroList.size(); i++){
                int countNoZero = 0;
                for(String s : noZeroList.get(i).split("")){
                    if(!s.equals("0")){
                        countNoZero++;
                    }
                }
               // System.out.println(countNoZero);
                lines.add(countNoZero);
            }
        }
        for(int i = 0; i < lines.size()-1; i++){
           result += lines.get(i) * lines.get(i + 1);
        }
        return result;
    }
}
