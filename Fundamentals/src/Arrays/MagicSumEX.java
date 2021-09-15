package Arrays;

import java.util.Scanner;

public class MagicSumEX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] nums = new int[input.length];
        int magicNum = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == magicNum){
                    System.out.println(nums[i] + " " + nums[j]);
                }
            }
        }
    }
}