package Fundamentals.Data.Types;

import java.util.Scanner;

public class SumDigitsEX {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String num = scanner.nextLine();
        int sum = 0;
        for (int i = 0; i < num.length(); i++) {
            int current = (int) num.charAt(i) - '0';
            sum += current;

        }
        System.out.println(sum);
    }
}
