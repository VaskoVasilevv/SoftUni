package Exam.Exam.dealership;

import java.util.*;

public class MatrixDemo {
    private static int rowPosition;
    private static int colPosition;
    private static char[][] matrix;
    private static int bombs;
    private static int foundBombs;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] tokens =scanner.nextLine().split(",");
        matrix = readMatrix(scanner, n);

        boolean isWin = false;
        boolean endofRoad = false;

            findSymbol('B');
        for (int i = 0; i < tokens.length; i++) {
            String direction = tokens[i];
            int currentPositionRow= rowPosition;
            int currentPositionCol= colPosition;
            matrix[rowPosition][colPosition] = '+';
            move(direction);
            if (isInBounds()){
                if (matrix[rowPosition][colPosition] == 'B'){
                    bombs--;
                    foundBombs++;
                    System.out.println("You found a bomb!");
                    matrix[rowPosition][colPosition] = '+';
                    if (bombs == 0){
                        isWin = true;
                        break;
                    }
                }else if (matrix[rowPosition][colPosition] == 'e'){
                    matrix[rowPosition][colPosition] = 's';
                    endofRoad = true;
                    break;
                }else {
                    matrix[rowPosition][colPosition] = 's';

                }
            }else {
                rowPosition = currentPositionRow;
                colPosition = currentPositionCol;
                matrix[rowPosition][colPosition] = 's';

            }

        }

        if (bombs == 0){
            System.out.println("Congratulations! You found all bombs!");
        }
        if (endofRoad){
            System.out.println(String.format("END! %d bombs left on the field",bombs));
        }
        if (bombs != 0 && !endofRoad){
            System.out.println(String.format("%d bombs left on the field. Sapper position: (%d,%d)",bombs,rowPosition,colPosition));
        }

        

    }

    private static void move(String direction) {
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
                if (matrix[row][col] == 'B') {
                    bombs++;

                }

            }
        }
    }

    private static boolean isInBounds() {
        return rowPosition >= 0 && rowPosition < matrix.length && colPosition >= 0 && colPosition < matrix[rowPosition].length;
    }

    private static char[][] readMatrix(Scanner scanner, int n) {
        char[][] matrix = new char[n][n];

        for (int r = 0; r < matrix.length; r++) {
            String input = scanner.nextLine().replaceAll(" ","");
            if (input.contains("s")) {
                rowPosition = r;
                colPosition = input.indexOf("s");
            }
            matrix[r] = input.toCharArray();
        }
        return matrix;
    }
}

