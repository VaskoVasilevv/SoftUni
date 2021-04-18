package Exam.P16December2020;

import java.util.Scanner;

public class Selling {
    private static int rowPosition;
    private static int colPosition;
    private static char[][] matrix;
    private static int money;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        matrix = readMatrix(scanner, n);
        boolean isInBakery = true;
        while (money < 50 && isInBakery) {
            matrix[rowPosition][colPosition] = '-';
            String direction = scanner.nextLine();

            switch (direction) {
                case "up":
                    rowPosition--;
                    break;
                case "down":
                    rowPosition++;
                    break;
                case "left":
                    colPosition--;
                    break;
                case "right":
                    colPosition++;
                    break;
            }
            if (isInBounds()){
                if (Character.isDigit(matrix[rowPosition][colPosition])){
                    money += matrix[rowPosition][colPosition] - '0';
                    matrix[rowPosition][colPosition] = 'S';

                }else if (matrix[rowPosition][colPosition] == 'O'){
                    matrix[rowPosition][colPosition] = '-';
                    findSymbol('O');
                    matrix[rowPosition][colPosition] = '-';
                }else {
                    matrix[rowPosition][colPosition] = 'S';
                }
            }else {
                isInBakery = false;
            }
        }
        if (!isInBakery && money < 50){
            System.out.println("Bad news, you are out of the ExamPreparation_2.ExamPreparation_2.bakery.");
        }else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.println("Money: "+ money);
        printMatrix();
    }

    private static void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int c = 0; c < matrix.length; c++) {
                System.out.print(matrix[i][c]);
            }
            System.out.println();
        }
    }

    private static void findSymbol(char Symbols) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'O'){
                    rowPosition= row;
                    colPosition = col;
                }

            }
        }
    }

    private static boolean isInBounds() {
        return rowPosition>=0 && rowPosition < matrix.length && colPosition >=0 && colPosition < matrix[rowPosition].length;
    }

    private static char[][] readMatrix(Scanner scanner, int n) {
        char[][] matrix = new char[n][n];

        for (int r = 0; r < matrix.length; r++) {
            String input = scanner.nextLine();
            if (input.contains("S")) {
                rowPosition = r;
                colPosition = input.indexOf("S");
            }
            matrix[r] = input.toCharArray();
        }
        return matrix;
    }
}
