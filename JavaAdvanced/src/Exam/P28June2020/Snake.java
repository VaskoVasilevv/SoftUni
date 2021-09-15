package Exam.P28June2020;

import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        char[][] matrix = readMatrix(scanner);
        int currentRow = findeFirstRow('S', matrix);
        int currentCol = findeFirstCol('S', currentRow, matrix);

        int food = 0;

        boolean isInTerritory = true;
        while (food < 10 && isInTerritory) {
            String command = scanner.nextLine();
            matrix[currentRow][currentCol] = '.';

            switch (command) {
                case "up":
                    currentRow--;
                    break;
                case "down":
                    currentRow++;
                    break;
                case "left":
                    currentCol--;
                    break;
                case "right":
                    currentCol++;
                    break;
            }
            if (isInBounds(currentRow, currentCol, matrix)) {
                if (matrix[currentRow][currentCol] == '-') {
                    matrix[currentRow][currentCol] = 'S';

                } else if (matrix[currentRow][currentCol] == '*') {
                    food++;
                    matrix[currentRow][currentCol] = 'S';

                } else if (matrix[currentRow][currentCol] == 'B') {
                    matrix[currentRow][currentCol] = '.';
                    currentRow = findeFirstRow('B', matrix);
                    currentCol = findeFirstCol('B', currentRow, matrix);
                    matrix[currentRow][currentCol] = 'S';
                }
            } else {
                isInTerritory = false;
                break;
            }

        }
        if (food < 10) {
            System.out.println("Game over!");
            System.out.println("Food eaten: " + food);
        } else {
            System.out.println("You won! You fed the snake.");
            System.out.println("Food eaten: " + food);
        }
        printMatrix(matrix);

    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean isInBounds(int row, int col, char[][] matrix) {
        return row >= 0 && row <= matrix.length - 1 && col >= 0 && col <= matrix.length - 1;
    }

    private static int findeFirstCol(char symbol, int row, char[][] matrix) {
        int index = -1;
        for (int col = 0; col < matrix.length; col++) {
            if (matrix[row][col] == symbol) {
                index = col;
                break;
            }
        }
        return index;
    }

    private static int findeFirstRow(char symbol, char[][] matrix) {

        int index = -1;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (symbol == matrix[r][c]) {
                    index = r;
                    break;
                }
            }
            if (index != -1) {
                break;
            }

        }
        return index;
    }

    private static char[][] readMatrix(Scanner scanner) {
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        for (int r = 0; r < matrix.length; r++) {
            String input = scanner.nextLine();
            matrix[r] = input.toCharArray();
        }
        return matrix;
    }
}
