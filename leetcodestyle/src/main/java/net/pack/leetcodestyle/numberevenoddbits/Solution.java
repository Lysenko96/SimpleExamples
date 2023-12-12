package net.pack.leetcodestyle.numberevenoddbits;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.evenOddBit(17);
        solution.evenOddBit(2);
    }

    public int[] evenOddBit(int n) {
        String binary = Integer.toString(n, 2);
        String[] arrBinary = binary.split("");
        List<String> reversed = Arrays.asList(arrBinary);
        Collections.reverse(Arrays.asList(arrBinary));
        int odd = 0;
        int even = 0;
        for(int i = 0; i < reversed.size(); i++){
            if(i % 2 == 0 && reversed.get(i).equals("1")) even++;
            else if (i % 2 != 0 && reversed.get(i).equals("1")) odd++;
        }
        return new int[]{even, odd};
    }
}
