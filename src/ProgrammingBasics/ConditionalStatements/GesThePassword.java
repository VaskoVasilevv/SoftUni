package ProgrammingBasics.ConditionalStatements;

import java.util.Scanner;

public class GesThePassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inpit = scanner.nextLine();

        if (inpit.equals("s3cr3t!P@ssw0rd")) {
            System.out.println("Welcome");
        }else {
            System.out.println("Wrong password!");
        }
    }
}
