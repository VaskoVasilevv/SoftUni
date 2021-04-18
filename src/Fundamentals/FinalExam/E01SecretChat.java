package Fundamentals.FinalExam;


import java.util.Scanner;
import java.util.regex.Pattern;

public class E01SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Reveal")) {
            String[] command = input.split(":\\|:");
            switch (command[0]) {
                case "InsertSpace":
                    int index = Integer.parseInt(command[1]);
                    if (index >= 0 && index < sb.length()) {
                        sb.insert(index, " ");
                    }
                    System.out.println(sb);
                    break;
                case "Reverse":
                    StringBuilder message = new StringBuilder(command[1]);

                    if (sb.indexOf(String.valueOf(message)) != -1) {
                        sb.delete(sb.indexOf(String.valueOf(message)), sb.indexOf(String.valueOf(message)) + message.length());
                        sb.append(message.reverse());

                        System.out.println(sb);
                    } else {
                        System.out.println("error");
                    }

                    break;
                case "ChangeAll":
                    String toChange = command[1];
                    String changes = command[2];
                    sb = new StringBuilder(sb.toString().replace(toChange, changes));
                    System.out.println(sb);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("You have a new text message: " + sb);
    }
}
