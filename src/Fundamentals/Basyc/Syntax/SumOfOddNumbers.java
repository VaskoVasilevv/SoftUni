package Fundamentals.Basyc.Syntax;

import java.util.Scanner;

public class SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int oddNum = 0;

        int all = 0;
        while (oddNum < num){
            sum ++;
            if (sum % 2 ==1){
                oddNum++;
                System.out.println(sum);
                all += sum;
            }
        }
        System.out.printf("Sum: %d", all);

    }
}

