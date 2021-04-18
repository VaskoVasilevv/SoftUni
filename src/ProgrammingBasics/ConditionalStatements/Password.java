package ProgrammingBasics.ConditionalStatements;

import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String correctPassword = scanner.nextLine();

        String inputPassword = scanner.nextLine();

        while (!inputPassword.equals(correctPassword)){
            inputPassword = scanner.nextLine();
        }
        System.out.printf("Welcome %s!",username);

    }
}
