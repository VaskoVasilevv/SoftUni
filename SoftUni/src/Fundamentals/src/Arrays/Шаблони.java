package bg.softuni.fundamentals.Arrays;

import java.util.Scanner;

public class Шаблони {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



    }

    private static int[] intArray(Scanner scanner) {
        String[] input = scanner.nextLine().split("\\s+");
        int [] time = new int[input.length];

        for (int i = 0; i < time.length; i++) {
            time[i] = Integer.parseInt(input[i]);
        }
        return time;
    }
    private static void printArray(String separator, int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
            if (i < array.length - 1) {
                System.out.println(separator);
            }
        }
        System.out.println();
    }
    private static void swapArray(int[] array, int a, int b) {
        int oldA = array[a];
        array[a] = array[b];
        array[b] = oldA;

    }
    private static void reverseArray (int [] array){
        for (int i = 0; i < array.length / 2 ; i++) {
            int current = array[i];
            array[i] = array[array.length -1 - i];
            array[array.length -1 - i] = current;
        }

    }
    private static void multiplyArray(int[] array, int a, int b) {

        array[a] = array[a] * array[b];
    }

    private static void decreaseArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            array[i]--;
        }
    }
}
