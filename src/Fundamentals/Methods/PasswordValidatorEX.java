package Fundamentals.Methods;

import java.util.Scanner;

public class PasswordValidatorEX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        boolean isBetween = checkIfIsBetween(password);
        boolean consist = checkIsConsist(password);
        boolean hasTwo = checkIfHaveTwoDigits(password);

        if (isBetween && consist && hasTwo) {
            System.out.println("Password is valid");
        }
        if (!isBetween){
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!consist) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!hasTwo) {
            System.out.println("Password must have at least 2 digits");
        }
    }

    public static boolean checkIfIsBetween(String password) {
        return password.length() >= 6 && password.length() <= 10;
    }

    public static boolean checkIsConsist(String password) {
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);
            boolean isleter = Character.isLetter(symbol);
            boolean isDigit = Character.isDigit(symbol);
            if (!isDigit && !isleter) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkIfHaveTwoDigits(String password) {
        int counter = 0;
        for (int i = 0; i < password.length(); i++) {
            char symbol = password.charAt(i);

            if (Character.isDigit(symbol)) {
                counter++;
            }

        }
        if (counter >= 2) {
            return true;
        } else {
            return false;
        }
    }
}
