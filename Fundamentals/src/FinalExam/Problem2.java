package FinalExam;

import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder(scanner.nextLine());

        String lines = scanner.nextLine();

        while (!lines.equals("For Azeroth")) {
            String[] tokens = lines.split(" ");
            String command = tokens[0];
            if (command.equals("GladiatorStance")) {
                for (int i = 0; i < sb.length(); i++) {
                    sb = new StringBuilder(sb.toString().replace(sb.charAt(i), sb.charAt(i)).toUpperCase());
                }
                System.out.println(sb);
            } else if (command.equals("DefensiveStance")) {
                for (int i = 0; i < sb.length(); i++) {
                    sb = new StringBuilder(sb.toString().replace(sb.charAt(i), sb.charAt(i)).toLowerCase());
                }
                System.out.println(sb);
            } else if (command.equals("Dispel")) {
                int index = Integer.parseInt(tokens[1]);
                String letter = tokens[2];
                if (index >= 0 && index < sb.length()) {
                    sb = new StringBuilder(sb.deleteCharAt(index));
                    sb.insert(index, letter);
                    System.out.println("Success!");
                } else {
                    System.out.println("Dispel too weak.");
                }
            } else if (command.equals("Target")) {
                if (tokens[1].equals("Change")) {
                    String substring = tokens[2];
                    String secondSubstring = tokens[3];
                    sb = new StringBuilder(sb.toString().replace(substring, secondSubstring));
                    System.out.println(sb);
                }
                if (tokens[1].equals("Remove")) {
                    String string = tokens[1];
                    String firstPart = sb.toString().substring(0, sb.indexOf(string));
                    String secondPart = sb.toString().substring(sb.indexOf(string));
                    sb = new StringBuilder(firstPart + secondPart);

                }
            }

            lines = scanner.nextLine();
        }
    }
}
