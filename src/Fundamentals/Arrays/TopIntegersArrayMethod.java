package Fundamentals.Arrays;

import java.util.Scanner;

public class TopIntegersArrayMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] array = readArray(scanner);
        printTop(array);

    }
    public static void printTop (int[]number ){
        for (int i = 0; i < number.length -1; i++) {
            int currentNUmber = number[i];
            boolean isTopInteger = true;
            for (int j = i + 1; j <number.length ; j++) {
                if (currentNUmber <= number[j]){
                    isTopInteger = false;
                    break;
                }

            }
            if (isTopInteger){
                System.out.print(currentNUmber + " ");
            }

        }
        System.out.println(number[number.length - 1]);
    }


    static int[] readArray(Scanner scanner) {

        String line = scanner.nextLine();
        String[] numbersAsStrings = line.split(" ");

        int[] array = new int[numbersAsStrings.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(numbersAsStrings[i]);
        }
        return array;
    }

}
