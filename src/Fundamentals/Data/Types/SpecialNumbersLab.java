package Fundamentals.Data.Types;

import java.util.Scanner;

public class SpecialNumbersLab {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n ; i++) {
            int lastDigit = i % 10;
            int middDigit = (i / 10) % 10;
            int first = i / 100;

            int sum = lastDigit + middDigit + first;
            if (sum == 5 || sum == 7 || sum == 11){
                System.out.printf("%d -> True%n",i);
            }else {
                System.out.printf("%d -> False%n",i);

            }

        }
    }
}
