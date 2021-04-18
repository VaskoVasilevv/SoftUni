package ProgrammingBasics.NestedLoops;

import java.util.Scanner;

public class VetParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int houers = Integer.parseInt(scanner.nextLine());
        double totalPrice = 0;

        for (int i = 1; i <= days; i++) {
            double currentDay = 0;

            for (int j = 1; j <= houers; j++) {
                if (i % 2 == 0 && j % 2 == 1) {
                    currentDay += 2.5;
                } else if (i % 2 == 1 && j % 2 == 0) {
                    currentDay += 1.25;
                } else {
                    currentDay += 1;
                }
            }
            System.out.printf("Day: %d - %.2f leva%n",i,currentDay);
            totalPrice += currentDay;

        }
        System.out.printf("Total: %.2f leva",totalPrice);
    }
}
