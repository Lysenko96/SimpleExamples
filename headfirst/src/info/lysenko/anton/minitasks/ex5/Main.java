package info.lysenko.anton.minitasks.ex5;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        float[] nums = new float[100];
        for(int i = 0; i < nums.length; i++)
            nums[i] = (float) Math.random() * 100;

        new Main().sort(nums);

        System.out.println(Arrays.toString(nums));

        Scanner in = new Scanner(System.in);
        System.out.print("Enter value position: ");
        String valStr = in.nextLine();
        System.out.println("previous: " + nums[Integer.parseInt(valStr)-1]);
        System.out.println("next: " + nums[Integer.parseInt(valStr)+1]);
        }

        void sort(float[] nums){
            for (int i = 0; i < nums.length; i++) {
                int min = i;
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] < nums[min])
                        min = j;
                }
                float tmp = nums[i];
                nums[i] = nums[min];
                nums[min] = tmp;
            }
    }
}
