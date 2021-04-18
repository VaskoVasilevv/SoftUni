package Fundamentals.Arrays;

import java.util.Scanner;

public class LiveDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int[] num = new int[input.length];

        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(input[i]);
        }
        int max = 0;
        int currentLength = 1;
        int digit = 0;
        for (int i = 0; i < num.length - 1; i++) {
            int current = num[i];
            int next = num[i + 1];
            if (current == next) {
                currentLength++;
                if (currentLength > max) {
                    max = currentLength;
                    digit = num[i];
                }
            }else {
                currentLength =1;
            }
        }
        for (int i = 0; i < max; i++) {
            System.out.print(digit + " ");

        }

    }
}


