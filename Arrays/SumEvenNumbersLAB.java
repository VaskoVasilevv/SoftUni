package bg.softuni.fundamentals.Arrays;

import java.util.Scanner;

public class SumEvenNumbersLAB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String [] inputAsString = input.split(" ");
        int [] num = new int[inputAsString.length];
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(inputAsString[i]);
            if (num[i] % 2 == 0){
                sum += num[i];
            }
        }
        System.out.println(sum);

    }
}
