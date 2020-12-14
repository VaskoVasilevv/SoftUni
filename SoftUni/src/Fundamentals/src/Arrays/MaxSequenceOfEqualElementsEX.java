package bg.softuni.fundamentals.Arrays;

import java.util.Scanner;

public class MaxSequenceOfEqualElementsEX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().split( " ");
        int [] numbers = new int [input.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        int bestLenght = 0;
        int dygit = 0;
        int currentLenght = 1;
        for (int i = 0; i < numbers.length -1; i++) {
            int currentElement = numbers[i];
            int nextElemnent = numbers[i + 1];
            if (currentElement == nextElemnent){
                currentLenght++;
                if (currentLenght > bestLenght){
                    bestLenght = currentLenght;
                    dygit = currentElement;

                }
            }else {
                currentLenght = 1;
            }
        }
        for (int i = 0; i < bestLenght; i++) {
            System.out.print(dygit + " ");

        }
    }
}
