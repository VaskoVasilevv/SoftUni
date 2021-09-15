package Exam.P17Dec2019;

import java.util.Scanner;
import java.util.stream.IntStream;

public class P02_PresentDelivery {
    private static int rowIndex;
    private static int colIndex;
    private static char currentChar;
    private static int countHappyKids = 0;
    private static int niceKidsLeft;
    private static int presents;
    private static char[][] neighbourhood;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        presents = Integer.parseInt(scan.nextLine());
        neighbourhood = readMatrix(scan, Integer.parseInt(scan.nextLine()));
        findSymbol();
        String command;

        while (!"Christmas morning".equals(command = scan.nextLine())) {
            neighbourhood[rowIndex][colIndex] = '-';
            if ("up".equals(command)) {
                rowIndex--;
            } else if ("down".equals(command)) {
                rowIndex++;
            } else if ("right".equals(command)) {
                colIndex++;
            } else if ("left".equals(command)) {
                colIndex--;
            }
            if (isInBounds(rowIndex, colIndex)) {
                currentChar = neighbourhood[rowIndex][colIndex];
                if (currentChar == 'V') {
                    countHappyKids++;
                    presents--;
                } else if (currentChar == 'C') {
                    checkPosition(rowIndex - 1, colIndex);
                    checkPosition(rowIndex + 1, colIndex);
                    checkPosition(rowIndex, colIndex + 1);
                    checkPosition(rowIndex, colIndex - 1);
                }
                neighbourhood[rowIndex][colIndex] = 'S';
            }
            if (!isInBounds(rowIndex, colIndex) || presents <= 0) {
                break;
            }
        }
        if (!isInBounds(rowIndex, colIndex) || (presents <= 0 && currentChar != 'C')) {
            System.out.println("Santa ran out of presents!");
        }
        printMatrix();
        findSymbol();

        if (niceKidsLeft > 0) {
            System.out.printf("No presents for %d nice kid/s.", niceKidsLeft);
        } else {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", countHappyKids);
        }
    }
    private static void checkPosition(int i, int j) {
        if (neighbourhood[i][j] == 'V' || neighbourhood[i][j] == 'X') {
            presents--;
            if (neighbourhood[i][j] == 'V') countHappyKids++;
        }
        neighbourhood[i][j] = '-';
    }
    private static void findSymbol() {
        niceKidsLeft = 0;
        for (int row = 0; row < neighbourhood.length; row++) {
            for (int col = 0; col < neighbourhood.length; col++) {
                if (neighbourhood[row][col] == 'V') {
                    niceKidsLeft++;
                } else if (neighbourhood[row][col] == 'S') {
                    rowIndex = row;
                    colIndex = col;
                }
            }
        }
    }
    private static void printMatrix() {
        for (char[] current : neighbourhood) {
            IntStream.range(0, current.length).forEach(j -> System.out.printf("%c ", current[j]));
            System.out.println();
        }
    }
    private static boolean isInBounds(int row, int col) {
        return row < neighbourhood.length && row >= 0 && col < neighbourhood.length && col >= 0;
    }
    private static char[][] readMatrix(Scanner scan, int n) {
        char[][] matrix = new char[n][n];
        for (int row = 0; row < n; row++) {
            matrix[row] = scan.nextLine().replaceAll("\\s+", "").toCharArray();
        }
        return matrix;
    }
}
