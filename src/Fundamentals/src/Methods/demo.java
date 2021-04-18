package Methods;

import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        printMiddleCharacters(input);
    }

    private static void printMiddleCharacters(String input) {
        int counter = input.length();

        if (counter % 2 == 0) {
            for (int i = input.length() / 2 - 1; i < input.length() / 2 + 1; i++) {
                char symbol = input.charAt(i);
                System.out.print(symbol);
            }
        } else {
            char symbol = input.charAt(input.length() / 2);
            System.out.print(symbol);
        }
    }

    private static boolean haveTwoDigits(String input) {
        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            char digit = input.charAt(i);
            if (Character.isDigit(digit)) {
                counter++;
            }
        }
        if (counter >= 2) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isLetterAndDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            boolean isLetter = Character.isLetter(symbol);
            boolean isDigit = Character.isDigit(symbol);
            if (!isLetter && !isDigit) {
                return false;
            }
        }
        return true;
    }

    private static boolean isBetwen(String input) {
        if (input.length() >= 6 && input.length() <= 10) {
            return true;
        }
        return false;
    }


    private static void printCharactersInRange(char first, char second) {
        if (first < second) {
            for (int i = first + 1; i < second; i++) {
                System.out.print((char) i + " ");
            }
        } else {
            for (int i = second + 1; i < first; i++) {
                System.out.print((char) i + " ");
            }
        }

    }


    public static int getVowels(String input) {
        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            char symbol = Character.toLowerCase(input.charAt(i));
            if (symbol == 'a' || symbol == 'e' || symbol == 'o' || symbol == 'u' || symbol == 'i') {

                counter++;
            }
        }
        return counter;
    }

}
