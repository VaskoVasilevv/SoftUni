package bg.softuni.fundamentals.FinalExam;

import java.util.Scanner;

public class E01AprilPasswordRest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        String commands = scanner.nextLine();
        while (!commands.equals("Done")) {
            String[] tokens = commands.split("\\s+");
            switch (tokens[0]) {
                case "TakeOdd":
                    String newPassword = "";
                    for (int i = 1; i < password.length(); i += 2) {
                        newPassword += password.charAt(i);
                    }
                    password = newPassword;
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    String first = password.substring(0, index);
                    String second = password.substring(index + length);
                    password = first + second;
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring = tokens[1];
                    String substitude = tokens[2];
                    if (password.contains(substring)) {
                        password = password.replaceAll(substring, substitude);
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            commands = scanner.nextLine();
        }
        System.out.println("Your password is: " + password);
    }
}
