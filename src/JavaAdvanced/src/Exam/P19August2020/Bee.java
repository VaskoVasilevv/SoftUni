package Exam.P19August2020;

import java.util.Arrays;
import java.util.Scanner;

public class Bee {

    static int beeRow, beeCol;
    static char[][] matrix;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        readMatrix(scan);
        int neededFlowers = 0;
        String input;

        while (!"End".equals(input = scan.nextLine())) {

            matrix[beeRow][beeCol] = '.';

            switch (input) {
                case "right":
                    beeCol++;
                    checkForBonus(1, "col");
                    break;
                case "left":
                    beeCol--;
                    checkForBonus(-1, "col");
                    break;
                case "down":
                    beeRow++;
                    checkForBonus(1, "row");
                    break;
                case "up":
                    beeRow--;
                    checkForBonus(-1, "row");
                    break;
            }
            if (indexesInBounds()) {
                if (matrix[beeRow][beeCol] == 'f') {
                    neededFlowers++;
                }
            } else {
                System.out.println("The bee got lost!");
                break;
            }
            matrix[beeRow][beeCol] = 'B';
        }
        if (neededFlowers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - neededFlowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", neededFlowers);
        }
        printMatrix();
    }

    private static void checkForBonus(int i, String dir) {
        while (indexesInBounds() && matrix[beeRow][beeCol] == 'O') {
            matrix[beeRow][beeCol] = '.';
            if (dir.equals("col")) {
                beeCol = Math.abs(beeCol) + i;
            } else {
                beeRow = Math.abs(beeRow) + i;
            }
        }
    }

    private static boolean indexesInBounds() {
        return (beeRow >= 0 && beeRow < matrix.length) && (beeCol >= 0 && beeCol < matrix[beeRow].length);
    }

    private static void readMatrix(Scanner scan) {
        int n = Integer.parseInt(scan.nextLine());
        matrix = new char[n][n];
        for (int row = 0; row < matrix.length; row++) {
            String input = scan.nextLine();
            matrix[row] = input.toCharArray();
            if (input.contains("B")) {
                beeRow = row;
                beeCol = input.indexOf('B');
            }
        }
    }

    private static void printMatrix() {
        Arrays.stream(matrix).map(row -> Arrays.toString(row).replaceAll("[\\[\\]]", "")
                .replaceAll(", ", "")).forEach(System.out::println);
    }
}
