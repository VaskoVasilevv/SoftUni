package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nXm = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[nXm[0]][nXm[1]];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

        }

        int bestSum = Integer.MIN_VALUE;
        int[] bestVector = new int[2];

        for (int i = 0; i < matrix.length -2; i++) {
            for (int j = 0; j < matrix[i].length -2; j++) {
                int[] start = new int[]{i, j};
                if (findSum(start, matrix) > bestSum) {
                    bestSum = findSum(start, matrix);
                    bestVector = start;
                }
            }

        }
        System.out.printf("Sum = %d%n",bestSum);
        printMatrix(bestVector, matrix);
    }

    private static int findSum(int[] vector, int[][] matrix) {
        int sum = 0;
        for (int row = vector[0]; row < vector[0] + 3; row++) {
            for (int col = vector[1]; col <  vector[1] +3; col++) {
                sum += matrix[row][col];
            }
        }
        return sum;
    }

    private static void printMatrix(int[] vector, int[][] matrix) {
        for (int row = vector[0]; row < vector[0] + 3; row++) {
            for (int col = vector[1]; col <  vector[1] +3; col++) {
                System.out.print(String.format("%d ",matrix[row][col]));

            }
            System.out.println();

        }
    }
}
