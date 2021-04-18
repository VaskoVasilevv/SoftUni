package Fundamentals.FinalExam;

import java.util.Locale;
import java.util.Scanner;

public class E01EmailValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String email = scanner.nextLine();

        String input = scanner.nextLine();
        while (!input.equals("Complete")) {
            String[] tokens = input.split(" ");

            switch (tokens[0]) {
                case "Make":
                    String type = tokens[1];
                    if (type.equals("Upper")) {
                        email = email.toUpperCase();
                    } else {
                        email = email.toLowerCase();
                    }
                    System.out.println(email);
                    break;
                case "GetDomain":
                    int count = Integer.parseInt(tokens[1]);
                    int indexDomain = email.length() - count;

                    System.out.println(email.substring(indexDomain));
                    break;
                case "GetUsername":
                    if (email.contains("@")) {
                        int indexOfEta = email.indexOf('@');
                        System.out.println(email.substring(0, indexOfEta));

                    } else {
                        System.out.println(String.format("The email %s doesn't contains @ symbol.", email));
                    }
                    break;
                case "Replace":
                    String ch = tokens[1];
                    email = email.replace(ch, "-");

                    System.out.println(email);
                    break;
                case "Encrypt":
                    for (int i = 0; i < email.length(); i++) {
                        char current = email.charAt(i);
                        System.out.print((int) current + " ");
                    }
                    System.out.println();
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
