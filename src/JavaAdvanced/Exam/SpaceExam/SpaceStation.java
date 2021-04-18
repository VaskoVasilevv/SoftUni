package JavaAdvanced.Exam.SpaceExam;

import java.util.Scanner;

public class SpaceStation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        char[][] matrix = readMatrix(scanner, matrixSize);

        int playerRow = getFirstRowSymbol('S', matrix);
        int playerCol = getFirstColSymbol('S', playerRow, matrix);

        boolean isInVoid = false;
        int power = 0;
        while ( power < 50) {
            String direction = scanner.nextLine();
            int currentPlayerRow = playerRow;
            int currentPlayerCol = playerCol;
            switch (direction) {
                case "up":
                    currentPlayerRow -= 1;
                    break;
                case "down":
                    currentPlayerRow += 1;
                    break;
                case "left":
                    currentPlayerCol -= 1;
                    break;
                case "right":
                    currentPlayerCol += 1;
                    break;
            }

            isInVoid = IsInSpace(currentPlayerRow,currentPlayerCol,matrix);
            if (isInVoid){
                matrix[playerRow][playerCol] = '-';
                break;
            }

            char currentSymbol = matrix[currentPlayerRow][currentPlayerCol];
            if (currentSymbol == '-'){
                matrix[playerRow][playerCol] = '-';
                matrix[currentPlayerRow][currentPlayerCol] = 'S';
                playerRow = currentPlayerRow;
                playerCol = currentPlayerCol;
            }else if (Character.isDigit(currentSymbol)){
                matrix[playerRow][playerCol] = '-';
                matrix[currentPlayerRow][currentPlayerCol] = 'S';
                playerRow = currentPlayerRow;
                playerCol = currentPlayerCol;

                power += currentSymbol - 48;
            }else if (currentSymbol == 'O'){
                matrix[playerRow][playerCol] = '-';
                matrix[currentPlayerRow][currentPlayerCol] = '-';

                playerRow = getFirstRowSymbol('O',matrix);
                playerCol = getFirstColSymbol('O',playerRow,matrix);
                matrix[playerRow][playerCol] = 'S';
            }
        }
        if (isInVoid){
            System.out.println("Bad news, the spaceship went to the void.");
        }else {
            System.out.println("Good news!");
        }
        System.out.println("Star power collected: " + power);

        printMatrix(matrix);


    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char symbol : chars) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private static boolean IsInSpace(int currentPlayerRow, int currentPlayerCol, char[][] matrix) {
        return currentPlayerRow < 0 || currentPlayerRow >= matrix.length
                || currentPlayerCol < 0 || currentPlayerCol >= matrix.length;
    }

    private static int getFirstColSymbol(char symbol, int row, char[][] matrix) {
        int index = -1;
        for (int col = 0; col < matrix.length; col++) {
            if (matrix[row][col] == symbol) {
                index = col;
                break;
            }
        }
        return index;
    }

    private static int getFirstRowSymbol(char symbol, char[][] matrix) {
        int index = -1;
        int length = matrix.length;
        for (int row = 0; row < length; row++) {
            for (int col = 0; col < length; col++) {
                if (matrix[row][col] == symbol) {
                    index = row;
                    break;
                }

            }
            if (index != -1) {
                break;
            }

        }
        return index;
    }


    private static char[][] readMatrix(Scanner scanner, int matrixSize) {
        char[][] matrix = new char[matrixSize][matrixSize];


        for (int col = 0; col < matrixSize; col++) {
            char[] row = scanner.nextLine().toCharArray();
            matrix[col] = row;

        }
        return matrix;
    }
}
