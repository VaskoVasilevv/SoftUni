package Exam.P22Feb2020;

import java.util.Arrays;
import java.util.Scanner;

public class ReVolt {
    static char[][] matrix;
    static int[] currentPosition = new int[2];
    static boolean isFinished=false;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int sizeMatrix = Integer.parseInt(scan.nextLine());
        int countCommands = Integer.parseInt(scan.nextLine());
        readMatrix(scan, sizeMatrix);

        while (countCommands-- > 0 && !isFinished) {
            matrix[currentPosition[0]][currentPosition[1]] = '-';
            int[] previousPosition = new int[]{currentPosition[0],currentPosition[1]};
            String command = scan.nextLine();
            checkMove(command);
            checkPosition(command,previousPosition);
        }

        System.out.println(isFinished ? "Player won!" : "Player lost!");
        printMatrix(matrix);

    }

    private static void checkPosition(String command,int[]previousPosition) {

        if (matrix[currentPosition[0]][currentPosition[1]] == 'F') {
            matrix[currentPosition[0]][currentPosition[1]] = 'f';
            isFinished = true;
        } else if (matrix[currentPosition[0]][currentPosition[1]] == 'B') {
            checkMove(command);
            checkPosition(command,previousPosition);
        } else if (matrix[currentPosition[0]][currentPosition[1]] == 'T') {
            currentPosition[0] = previousPosition[0];
            currentPosition[1] = previousPosition[1];
            matrix[currentPosition[0]][currentPosition[1]] = 'f';
        } else {
            matrix[currentPosition[0]][currentPosition[1]] = 'f';
        }
    }

    private static void checkMove(String command) {
        if ("up".equals(command)) {
            currentPosition[0]--;
            if (currentPosition[0] < 0) {
                currentPosition[0] = matrix.length - 1;
            }
        } else if ("down".equals(command)) {
            currentPosition[0]++;
            if (currentPosition[0] > matrix.length - 1) {
                currentPosition[0] = 0;
            }
        } else if ("left".equals(command)) {
            currentPosition[1]--;
            if (currentPosition[1] < 0) {
                currentPosition[1] = matrix.length - 1;
            }
        } else if ("right".equals(command)) {
            currentPosition[1]++;
            if (currentPosition[1] > matrix.length - 1) {
                currentPosition[1] = 0;
            }
        }
    }

    private static void readMatrix(Scanner scan, int size) {
        matrix = new char[size][size];
        for (int row = 0; row < matrix.length; row++) {
            String input = scan.nextLine();
            matrix[row] = input.toCharArray();
            if (input.contains("f")) {
                currentPosition[0] = row;
                currentPosition[1] = input.indexOf('f');
            }
        }
    }

    private static void printMatrix(char[][] matrix) {
        Arrays.stream(matrix).map(row -> Arrays.toString(row)
                .replaceAll("[\\[\\], ]", "")).forEach(System.out::println);
    }
}
