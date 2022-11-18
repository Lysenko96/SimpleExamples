package net.pack.leetproblems.wateringplants;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().wateringPlants(new int[]{1, 1, 1, 4, 2, 3}, 4));
    }

    public int wateringPlants(int[] plants, int capacity) {
        int step = 0;
        int temp = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (temp < plants[i]) {
                for (int j = 0; j < i; j++) {
                    step += 2;
                }
                //System.out.println(step);
                temp = capacity;
            }
            temp -= plants[i];
            step++;
           // System.out.println(temp);
            //System.out.println(step);
        }
        //System.out.println(step);
        return step;
    }
}
