package bg.softuni.fundamentals.Arrays;

import java.util.Scanner;

public class CondenseArrayToNumberLAB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] intAsString = scanner.nextLine().split(" ");
        int[] nums = new int[intAsString.length];


        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(intAsString[i]);

        }
        while (nums.length > 1) {
            int[] condensed = new int[nums.length - 1];

            for (int i = 0; i < condensed.length ; i++) {
                condensed[i] = nums[i] + nums[i + 1];
            }
            nums = condensed;
        }
        System.out.print(nums[0]);

    }
}
