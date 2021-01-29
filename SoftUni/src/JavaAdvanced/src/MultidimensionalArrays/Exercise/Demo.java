package MultidimensionalArrays.Exercise;

import com.sun.jdi.event.StepEvent;

import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixRowAndCol =Arrays.stream ((scanner.nextLine().split(" "))).mapToInt(Integer::parseInt).toArray();

        int rows = matrixRowAndCol[0];
        int cols = matrixRowAndCol[1];

       String [][] matrix = new String[rows][cols];
        char start = 'a';
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String palindrome = "" +start + (char) (start+col) + start;
                matrix[row][col] = palindrome;
            }
            start = (char) (start + 1);

        }
        System.out.println();

    }
}
