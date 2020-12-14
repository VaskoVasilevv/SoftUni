package bg.softuni.fundamentals.Methods;

import java.util.Scanner;

public class NxNMatrixEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        printNtnMatrix(n);

    }

    private static void printNtnMatrix(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(n + " ");

            }
            System.out.println();

        }
    }
}
