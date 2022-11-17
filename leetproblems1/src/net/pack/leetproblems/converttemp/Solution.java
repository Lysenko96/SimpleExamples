package net.pack.leetproblems.converttemp;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().convertTemperature(36.5)));
    }

    public double[] convertTemperature(double celsius) {
        double[] ars = new double[2];
        ars[0] = celsius + 273.15;
        ars[1] = celsius * 1.8 + 32;
        return ars;
    }
}
