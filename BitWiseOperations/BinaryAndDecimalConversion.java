package bg.softuni.fundamentals.BitWiseOperations;

import java.util.Scanner;

public class BinaryAndDecimalConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String num = "1000111";
        int sum = 0;
        int magnitude = 1;
        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = num.charAt(i) - '0';

            sum = sum + digit * magnitude;
            magnitude = magnitude * 2;

        }
        System.out.println(sum);
    }
}
