package JavaAdvanced.Exam.P26Oct2020;

import java.util.Scanner;

public class BookWorm {
    private static char[][] matrix;
    private static int playerRow;
    private static int playerCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scanner.nextLine());
        matrix = readMatrix(scanner, Integer.parseInt(scanner.nextLine()));

        String command;
        while (!"end".equals(command = scanner.nextLine())) {
            matrix[playerRow][playerCol] = '-';
            int currentRow = playerRow;
            int currentCol = playerCol;
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
            if (isInBounds(currentRow, currentCol)) {
            char symbol = matrix[currentRow][currentCol];
                if (symbol != '-') {
                    input.append(symbol);
                }
                playerRow = currentRow;
                playerCol = currentCol;
            }else {
                input.deleteCharAt(input.length()-1);
            }
            matrix[playerRow][playerCol] = 'P';
        }
        System.out.println(input.toString());
        print();
    }

    private static void print() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean isInBounds(int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix.length;
    }

    private static char[][] readMatrix(Scanner scanner, int n) {
        char[][] matrix = new char[n][n];

        for (int r = 0; r < matrix.length; r++) {
            String input = scanner.nextLine();
            if (input.contains("P")) {
                playerRow = r;
                playerCol = input.indexOf('P');
            }
            matrix[r] = input.toCharArray();
        }
        return matrix;
    }
}
