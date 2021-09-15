package NestedLoops;

import java.util.Scanner;

public class MobileOperator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String period = scanner.nextLine();
        String type = scanner.nextLine();
        String internet = scanner.nextLine();
        int months = Integer.parseInt(scanner.nextLine());

        double price = 0;

        switch (period) {
            case "one":
                switch (type) {
                    case "Small":
                        price = 9.98;
                        break;
                    case "Middle":
                        price = 18.99;
                        break;
                    case "Large":
                        price = 25.98;
                        break;
                    case "ExtraLarge":
                        price = 35.99;
                        break;
                }
                break;
            case "two":
                switch (type) {
                    case "Small":
                        price = 8.58;
                        break;
                    case "Middle":
                        price = 17.09;
                        break;
                    case "Large":
                        price = 23.59;
                        break;
                    case "ExtraLarge":
                        price = 31.79;
                        break;
                }
                break;
        }
        if (internet.equals("yes")) {
            if (price <= 10) {
                price += 5.5;
            } else if (price <= 30) {
                price += 4.35;
            } else if (price > 30) {
                price += 3.85;
            }
        }
        if (period.equals("two")) {
            price = price - price * 0.0375;

        }
    }
}
