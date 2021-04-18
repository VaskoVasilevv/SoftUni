package JavaAdvanced.MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(", ");

        int rows = Integer.parseInt(tokens[0]);
        int cowls = Integer.parseInt(tokens[1]);

        int[][] matrix = new int[rows][cowls];

        for (int i = 0; i < rows; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();

            matrix[i] = arr;
        }
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int curr = matrix[i][j];
                sum += curr;

            }

        }
        System.out.println(rows);
        System.out.println(cowls);
        System.out.println(sum);
    }
}
