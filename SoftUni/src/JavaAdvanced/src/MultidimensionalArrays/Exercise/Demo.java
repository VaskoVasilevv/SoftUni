package MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        String[][] matrix = new String[Integer.parseInt(tokens[0])][Integer.parseInt(tokens[1])];


    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillMatrix(int rowsAndCols, String pattern) {

        int num = 1;
        int[][] matrix = new int[rowsAndCols][rowsAndCols];
        if (pattern.equals("A")) {

            for (int col = 0; col < matrix.length; col++) {
                for (int row = 0; row < matrix[col].length; row++) {
                    matrix[row][col] = num++;

                }
            }
        } else if (pattern.equals("B")) {
            for (int col = 0; col < matrix.length; col++) {
                if (col % 2 == 0) {
                    for (int row = 0; row < matrix[col].length; row++) {
                        matrix[row][col] = num++;
                    }
                } else {
                    for (int row = matrix[col].length - 1; row >= 0; row--) {
                        matrix[row][col] = num++;
                    }
                }
            }
        }
        return matrix;
    }
}
