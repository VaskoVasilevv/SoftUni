package Fundamentals.Basyc.Syntax;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String password = "";

        for (int i = username.length() - 1; i >= 0; i--) {
            char symbol = username.charAt(i);
            password += symbol;
        }
        for (int i = 0; i < 4; i++) {
            String currentPassword = scanner.nextLine();
            if (currentPassword.endsWith(password)){
                System.out.printf("User %s logged in.",username);
                break;
            }else if (!password.equals(currentPassword) && i >= 0 && i < 3){
                System.out.println("Incorrect password. Try again.");
            }else if (!password.equals(currentPassword)&& i == 3){
                System.out.printf("User %s blocked!",username);
            }


        }
    }
}
