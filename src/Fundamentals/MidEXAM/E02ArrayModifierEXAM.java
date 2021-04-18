package Fundamentals.MidEXAM;

import java.util.Scanner;

public class E02ArrayModifierEXAM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] array = intArray(scanner);

        String line = scanner.nextLine();
        while (!line.equals("end")) {
            String[] command = line.split(" ");
            switch (command[0]) {
                case "swap":
                    swapArray(array,Integer.parseInt(command[1]),Integer.parseInt(command[2]));
                    break;
                case "multiply":
                    multiplyArray(array,Integer.parseInt(command[1]),Integer.parseInt(command[2]));
                    break;
                case "decrease":
                    decreaseArray(array);
                    break;
            }
            line = scanner.nextLine();
        }
        printArray(", ",array);

    }

    private static void swapArray(int[] array, int a, int b) {
        int oldA = array[a];
        array[a] = array[b];
        array[b] = oldA;

    }

    private static void multiplyArray(int[] array, int a, int b) {

        array[a] = array[a] * array[b];
    }

    private static void decreaseArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            array[i]--;
        }
    }

    private static int[] intArray(Scanner scanner) {
        String[] input = scanner.nextLine().split("\\s+");
        int[] time = new int[input.length];

        for (int i = 0; i < time.length; i++) {
            time[i] = Integer.parseInt(input[i]);
        }
        return time;
    }

    private static void printArray(String separator, int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(separator);
            }
        }
        System.out.println();
    }
}
