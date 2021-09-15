package Abstraction.Ex.jediGalaxi;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimension = readArray(scanner);

        int[][] matrix = fillMatrix(dimension);

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] rowAndCol = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilRowAndCol = readArray(scanner);
            int row = evilRowAndCol[0];
            int col = evilRowAndCol[1];

            extracted(matrix, row, col);

            row = rowAndCol[0];
            col = rowAndCol[1];

            sum = getSum(matrix, sum, row, col);

            command = scanner.nextLine();
        }

        System.out.println(sum);


    }

    private static long getSum(int[][] matrix, long sum, int row, int col) {
        while (row >= 0 && col < matrix[1].length) {
            if ( row < matrix.length && col >= 0 && col < matrix[0].length) {
                sum += matrix[row][col];
            }

            col++;
            row--;
        }
        return sum;
    }

    private static void extracted(int[][] matrix, int row, int col) {
        while (row >= 0 && col >= 0) {
            if ( row < matrix.length  && col < matrix[0].length) {
                matrix[row][col] = 0;
            }
            row--;
            col--;
        }
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }

    private static int[][] fillMatrix(int[] dimension) {
        int [][] matrix = new  int[dimension[0]][dimension[1]];
        int value = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = value++;
            }
        }
        return matrix;
    }
}
