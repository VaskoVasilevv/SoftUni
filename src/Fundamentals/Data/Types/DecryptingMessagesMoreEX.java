package Fundamentals.Data.Types;

import java.util.Scanner;

public class DecryptingMessagesMoreEX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            double n1 = scanner.nextDouble();
            double n2 = scanner.nextDouble();
            int sum = 0;
            if (n1 > n2) {
                double firstNUm = Math.abs(n1);
                while (firstNUm > 0) {
                    sum += firstNUm % 10;
                    firstNUm /= 10;
                }
            } else {
                double secondNum = Math.abs(n2);
                while (secondNum > 0) {
                    sum += secondNum % 10;
                    secondNum /= 10;
                }
            }
            System.out.println(Math.abs(sum));
        }
    }
}

