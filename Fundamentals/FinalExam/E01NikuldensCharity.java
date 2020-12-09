package bg.softuni.fundamentals.FinalExam;

import java.util.Scanner;


public class E01NikuldensCharity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String encrypted = scanner.nextLine();

        String command = scanner.nextLine();
        while (!command.equals("Finish")) {
            String[] commandsAndParts = command.split(" ");
            String commandName = commandsAndParts[0];

            switch (commandName) {
                case "Replace":
                    encrypted = replace(encrypted, commandsAndParts[1].charAt(0), commandsAndParts[2].charAt(0));
                    break;
                case "Cut":
                    int beginIndex = Integer.parseInt(commandsAndParts[1]);
                    int endIndex = Integer.parseInt(commandsAndParts[2]);
                    encrypted = cut(encrypted, beginIndex, endIndex);
                    break;
                case "Make":
                    encrypted = make(encrypted, commandsAndParts[1]);
                    break;
                case "Check":
                    if (encrypted.contains(commandsAndParts[1])) {
                        System.out.println("Message contains " + commandsAndParts[1]);
                    } else {
                        System.out.println("Message doesn't contain " + commandsAndParts[1]);
                    }
                    break;
                case "Sum":
                    int beginSumIndex = Integer.parseInt(commandsAndParts[1]);
                    int endSumIndex = Integer.parseInt(commandsAndParts[2]);
                    sum(encrypted, beginSumIndex, endSumIndex);
                    break;
            }

            command = scanner.nextLine();
        }

    }

    private static void sum(String encrypted, int beginSumIndex, int endSumIndex) {
        if (areValidIndex(encrypted.length(), beginSumIndex, endSumIndex)) {
            int sum = 0;
            for (int i = beginSumIndex; i <= endSumIndex; i++) {
                sum += encrypted.charAt(i);
            }
            System.out.println(sum);
        }
    }

    private static String make(String encrypted, String targetCase) {
        if (targetCase.equals("Upper")) {
            encrypted = encrypted.toUpperCase();
        } else {
            encrypted = encrypted.toLowerCase();
        }
        System.out.println(encrypted);
        return encrypted;
    }


    private static String cut(String encrypted, int beginIndex, int endIndex) {
        int length = encrypted.length();
        if (areValidIndex(encrypted.length(), beginIndex, endIndex)) {
            String firstPart = encrypted.substring(0, beginIndex);
            String secondPart = encrypted.substring(endIndex + 1, length);
            System.out.println(firstPart + secondPart);
            return firstPart + secondPart;

        }

        return encrypted;

    }

    private static boolean areValidIndex(int length, int beginIndex, int endIndex) {
        if (beginIndex >= 0 && beginIndex < length && endIndex >= 0 && endIndex < length) {
            return true;
        } else {
            System.out.println("Invalid index");
            return false;
        }
    }

    private static String replace(String encrypted, char serchFor, char replaceWith) {
        encrypted = encrypted.replace(serchFor, replaceWith);
        System.out.println(encrypted);
        return encrypted;
    }
}
