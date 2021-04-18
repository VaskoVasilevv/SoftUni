package JavaAdvanced.Exam.Demo23Oct2019;

import java.util.Locale;
import java.util.Scanner;
import java.util.stream.IntStream;

public class THeGarden {
    private static int carrots = 0;
    private static int potatoes = 0;
    private static int lettuce = 0;
    private static int harmedVegetables = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][];

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine().replaceAll(" ", "");
            matrix[i] = input.toCharArray();
        }


        String input = scanner.nextLine();
        while (!"End of Harvest".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Harvest":
                    int row = Integer.parseInt(tokens[1]);
                    int col = Integer.parseInt(tokens[2]);
                    if (isExist(row, col, matrix)) {
                        chckTheLetter(row, col, matrix);
                    }
                    break;
                case "Mole":
                    row = Integer.parseInt(tokens[1]);
                    col = Integer.parseInt(tokens[2]);
                    String direction = tokens[3];
                    if (isExist(row, col, matrix)) {
                        move(direction, row, col, matrix);
                    }

                    break;
            }

            input = scanner.nextLine();
        }
        printMatrix(matrix);
        System.out.println("Carrots: " + carrots);
        System.out.println("Potatoes: " + potatoes);
        System.out.println("Lettuce: " + lettuce);
        System.out.println("Harmed vegetables: " + harmedVegetables);
    }

    private static void move(String direction, int row, int col, char[][] matrix) {
        harmTheVegetable(row, col, matrix);

        switch (direction.toLowerCase(Locale.ROOT)) {
            case "up":
                while (row >= 0) {
                    if (isExist(row,col,matrix)) {
                        harmTheVegetable(row, col, matrix);
                    }
                    row -=2;
                }
//                for (int rows = row -2 ; rows >= 0; rows -= 2) {
//                    harmTheVegetable(rows, col, matrix);
//                }
                break;
            case "down":
                while (row < matrix.length){
                    if (isExist(row,col,matrix)) {
                        harmTheVegetable(row, col, matrix);
                    }
                    row += 2;
                }
//                for (int r = row; r < matrix.length; r += 2) {
//                    harmTheVegetable(r, col, matrix);
//                }
                break;
            case "left":
                while (col >= 0){
                    if (isExist(row,col,matrix)) {
                        harmTheVegetable(row, col, matrix);
                    }
                    col -=2;
                }
//                for (int c = col; c >= 0; c -= 2) {
//                    harmTheVegetable(row, c, matrix);
//                }
                break;
            case "right":
                while (col< matrix[row].length){
                    if (isExist(row,col,matrix)) {
                        harmTheVegetable(row, col, matrix);
                    }
                    col+= 2;
                }
//                for (int c = col; c < matrix[row].length; c += 2) {
//                    harmTheVegetable(row, c, matrix);
//                }
                break;
        }


    }

    private static void harmTheVegetable(int row, int col, char[][] matrix) {
        if (matrix[row][col] != ' ') {
            harmedVegetables += 1;
        }
        matrix[row][col] = ' ';

    }

    private static void printMatrix(char[][] output) {
        for (char[] current : output) {
            IntStream.range(0, current.length).forEach(j -> System.out.printf("%c ", current[j]));
            System.out.println();
        }
    }

    private static void chckTheLetter(int row, int col, char[][] matrix) {
        if (matrix[row][col] == 'C') {
            carrots += 1;
        } else if (matrix[row][col] == 'L') {
            lettuce += 1;
        } else if (matrix[row][col] == 'P') {
            potatoes += 1;
        }
        matrix[row][col] = ' ';
    }

    private static boolean isExist(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
