package Arrays;

import java.util.Scanner;

public class EqualArraysLAB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstArrayString = scanner.nextLine();
        String[] firstNumStrings = firstArrayString.split(" ");
        int[] firstArray = new int[firstNumStrings.length];
        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = Integer.parseInt(firstNumStrings[i]);
        }
        String secondArrayString = scanner.nextLine();
        String[] secondNumStrings = secondArrayString.split(" ");
        int[] secondArray = new int[secondNumStrings.length];
        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = Integer.parseInt(secondNumStrings[i]);
        }
        boolean areEqual = true;
        int different = -1;
        if (firstArray.length != secondArray.length) {
            areEqual = false;
        } else {
            for (int i = 0; i < firstArray.length; i++) {
                if (firstArray[i] != secondArray[i]) {
                    areEqual = false;
                    different = i;
                    break;
                }
            }

        }
        if (areEqual) {
            int sum = 0;
            for (int number : firstArray) {
                sum += number;
            }
            System.out.printf("Arrays are identical. Sum: %d", sum);
        } else {
            System.out.println("Arrays are not identical. Found difference at " + different + " index.");
        }

    }
}
