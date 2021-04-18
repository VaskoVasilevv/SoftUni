package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int rows = Integer.parseInt(scanner.nextLine());
        int cowls = Integer.parseInt(scanner.nextLine());

        char[][] first = readMatrix(scanner, rows, cowls);
        char[][] second = readMatrix(scanner, rows, cowls);

        char[][] output = new char[rows][cowls];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cowls; col++) {
                output[row][col] =
                        first[row][col] == second[row][col]
                                ? first[row][col]
                                : '*';

            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cowls; col++) {
                char symbol = output[row][col];
                System.out.print(symbol + " ");

            }
            System.out.println();
        }


    }

    public static char[][] readMatrix(Scanner scanner, int rows, int cowls) {
        char[][] matrix = new char[rows][cowls];
        for (int i = 0; i < rows; i++) {
            String[] symbols = scanner.nextLine().split(" ");
            for (int col = 0; col < cowls; col++) {
                matrix[i][col] = symbols[col].charAt(0);
            }
        }
        return matrix;
    }
}
