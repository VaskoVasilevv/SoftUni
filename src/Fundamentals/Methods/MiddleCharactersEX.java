package Fundamentals.Methods;

import java.util.Scanner;

public class MiddleCharactersEX {
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
}

