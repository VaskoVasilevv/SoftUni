package Fundamentals.Methods;

import java.util.Scanner;

public class PrintingTriangle {

    public static void main(String[] args) {
        int maxLineInt = new Scanner(System.in).nextInt();
        for (int i = 1; i <= maxLineInt; i++) {
            printNumbersIncreased(i);
        }
        for (int i = maxLineInt - 1; i >= 1; i--) {
            printNumbersIncreased(i);
        }
    }

    private static void printNumbersIncreased(int maxNumber) {
        for (int i = 1; i <= maxNumber; i++) {
            System.out.print(i + " ");

        }
        System.out.println();
    }
}

