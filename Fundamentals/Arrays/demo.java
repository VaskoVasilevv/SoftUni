package bg.softuni.fundamentals.Arrays;

import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[]{1, 2, 3,};

        for (int number : numbers) {
            System.out.println(number);
        }
        // su6tototo kato for cikul

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            System.out.println(number);
        }

    }
}
