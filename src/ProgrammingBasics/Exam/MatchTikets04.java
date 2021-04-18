package ProgrammingBasics.Exam;

import java.util.Scanner;

public class MatchTikets04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budgegt = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        int people = Integer.parseInt(scanner.nextLine());


        if (people <= 4) {
            budgegt = budgegt - budgegt * 0.75;
        } else if (people <= 9) {
            budgegt = budgegt - budgegt * 0.60;
        } else if (people <= 24) {
            budgegt = budgegt - budgegt / 2;
        } else if (people <= 49) {
            budgegt = budgegt - budgegt * 0.40;
        } else if (people >= 50) {
            budgegt = budgegt - budgegt * 0.25;
        }
        if (input.equals("Normal")) {
            double Normal = people * 249.99;
            if (budgegt >= Normal) {
                double ostavat = budgegt - Normal;
                System.out.printf("Yes! You have %.2f leva left.", ostavat);
            } else {
                double ostavat = Normal - budgegt;
                System.out.printf("Not enough money! You need %.2f leva.", ostavat);
            }
        }
        if (input.equals("VIP")) {
            double VIP = people * 499.99;
            if (budgegt >= VIP) {
                double ostavat = budgegt - VIP;
                System.out.printf("Yes! You have %.2f leva left.", ostavat);
            } else {
                double ostavat = VIP - budgegt;
                System.out.printf("Not enough money! You need %.2f leva.", ostavat);
            }
        }
    }
}