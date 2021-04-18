package ProgrammingBasics.Exam;

import java.util.Scanner;

public class Renovation04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int procent = Integer.parseInt(scanner.nextLine());

        int walls = a * b * 4;
        walls = (int) Math.ceil(walls - (walls * 1.0 / 100 * procent));

        String input = scanner.nextLine();
        while (!input.equals("Tired!")) {
            walls -= Integer.parseInt(input);
            if (walls <= 0) {
                break;
            }
            input = scanner.nextLine();
        }
        if (walls > 0) {
            System.out.printf("%d quadratic m left.", walls);
        } else if (walls == 0) {
            System.out.println("All walls are painted! Great job, Pesho!");
        } else {
            System.out.printf("All walls are painted and you have %d l paint left!", Math.abs(walls));
        }
    }
}



