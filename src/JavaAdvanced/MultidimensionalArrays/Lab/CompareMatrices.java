package JavaAdvanced.MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

        boolean areEqual = compareMatrices(firstMatrix, secondMatrix);
        System.out.println(areEqual ? "equal" : "not equal");
    }

    private static boolean compareMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            int[] firstArr = firstMatrix[row];
            int[] secondArr = secondMatrix[row];
            if (firstArr.length != secondArr.length) {
                return false;
            }
            for (int col = 0; col < firstArr.length; col++) {
                if (firstArr[col] != secondArr[col]) {
                    return false;
                }

            }

        }
        return true;
    }

    public static int[][] readMatrix(Scanner scanner) {
        String[] tokens = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(tokens[0]);
        int cowls = Integer.parseInt(tokens[1]);

        int[][] matrix = new int[rows][cowls];

        for (int i = 0; i < rows; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            matrix[i] = arr;
        }
        return matrix;
    }
}
