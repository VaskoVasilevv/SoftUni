package Basyc.Syntax;

import java.util.Scanner;

public class PassedOrFailed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double input = Double.parseDouble(scanner.nextLine());

        if (input > 2.99){
            System.out.println("Passed!");
        }else {
            System.out.println("Failed!");
        }
    }
}
