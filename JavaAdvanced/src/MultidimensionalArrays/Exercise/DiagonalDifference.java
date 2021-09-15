package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = fillMatrix(scanner, size,size);

        int sumFirst = 0;
        int sumSecond = 0;

        for (int row = 0; row < matrix.length; row++) {
            sumFirst += matrix[row][row];
            sumSecond += matrix[row][(matrix.length -1)-row];
        }

        System.out.println(Math.abs(sumFirst - sumSecond) );
    }
    public static int[][] fillMatrix(Scanner scanner, int cols, int rows) {

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
