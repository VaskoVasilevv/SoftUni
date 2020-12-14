package bg.softuni.fundamentals.FinalExam;

import java.util.Scanner;

public class E01AugustTheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder encryptedMessage = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("Decode")) {
            String[] tokens = input.split("\\|");
            switch (tokens[0]) {
                case "ChangeAll":
                    String oldString = tokens[1];
                    String newString = tokens[2];

                    encryptedMessage = new StringBuilder(encryptedMessage.toString().replace(oldString, newString));

                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    String replacment = tokens[2];

                    encryptedMessage.insert(index, replacment);

                    break;
                case "Move":
                    int num = Integer.parseInt(tokens[1]);
                    for (int i = 0; i < num; i++) {
                        char indexOf = encryptedMessage.charAt(0);
                        encryptedMessage.append(indexOf);
                        encryptedMessage.deleteCharAt(0);

                    }
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("The decrypted message is: " + encryptedMessage);
    }

    static boolean isValidIndex(StringBuilder s, int index) {
        return index >= 0 && index < s.length();
    }
}
