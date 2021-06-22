package Arrays;

import java.util.Scanner;

public class TopIntegersEX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int [] number = new int[input.length];

        for (int i = 0; i < number.length; i++) {
            number[i] = Integer.parseInt(input[i]);


        }
        for (int i = 0; i < number.length -1; i++) {
            int currentNUmber = number[i];
            boolean isTopInteger = true;
            for (int j = i + 1; j <number.length ; j++) {
                if (currentNUmber <= number[j]){
                    isTopInteger = false;
                    break;
                }

            }
            if (isTopInteger){
                System.out.print(currentNUmber + " ");
            }

        }
        System.out.println(number[number.length - 1]);

    }
}
