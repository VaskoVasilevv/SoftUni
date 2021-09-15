package Exam;

import java.util.Scanner;

public class Flowers04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hrizantemi = Integer.parseInt(scanner.nextLine());
        int roses = Integer.parseInt(scanner.nextLine());
        int lale = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        String day = scanner.nextLine();
        double price = 0;
        switch (season) {
            case "Spring":
                price = hrizantemi * 2 + roses * 4.10 + lale * 2.50;
                if (day.equals("Y")) {
                    price += price * 0.15;
                }
                if (lale >= 7) {
                    price = price - price * 0.05;
                }
                break;
            case "Summer":
                price = hrizantemi * 2 + roses * 4.10 + lale * 2.50;
                if (day.equals("Y")) {
                    price += price * 0.15;
                }
                break;
            case "Autumn":
                price = hrizantemi * 3.75 + roses * 4.50 + lale * 4.15;
                if (day.equals("Y")) {
                    price += price * 0.15;
                }
                break;
            case "Winter":
                price = hrizantemi * 3.75 + roses * 4.50 + lale * 4.15;
                if (day.equals("Y")) {
                    price += price * 0.15;
                }
                if (roses >= 10) {
                    price = price - price * 0.10;
                }
                break;
        }
        double total = hrizantemi + roses + lale;
        if (total >= 20) {
            price = price - price * 0.20;
        }
        price += 2;
        System.out.printf("%.2f",price);
    }
}
