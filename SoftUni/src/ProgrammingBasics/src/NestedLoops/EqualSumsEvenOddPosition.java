package NestedLoops;

import java.util.Scanner;

public class EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        for (int i = a; i <= b; i++) {
            String courentNum = "" + i;
            int oddSum = 0;
            int evenSum = 0;
            for (int j = 0; j < courentNum.length(); j++) {
                int courentDigit = Integer.parseInt("" + courentNum.charAt(j));

                if (j % 2 == 0) {
                evenSum += courentDigit;
                } else {
                oddSum += courentDigit;
                }
            }
            if (oddSum == evenSum){
                System.out.print(i + " ");
            }

        }
    }
}


