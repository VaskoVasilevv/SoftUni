package ProgrammingBasics.Exam;

import java.util.Scanner;

public class CatWallking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int minutes = Integer.parseInt(scanner.nextLine());
        int broiRazhodki = Integer.parseInt(scanner.nextLine());
        double calorii = Double.parseDouble(scanner.nextLine());

        double result = minutes * broiRazhodki * 5;
        double nujniKalorii = calorii / 2;
        if (result >= nujniKalorii) {
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %.0f.", result);
        } else if (result < nujniKalorii) {
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %.0f.", result);
        }
    }
}
