package ProgrammingBasics.LastProjeckt;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        String room = scanner.nextLine();
        String grade = scanner.nextLine();

        int nights = days - 1;
        double price = 0;

        switch (room) {
            case "room for one person":
                price = nights * 18;
                break;
            case "apartment":
                price = nights * 25;
                if (days < 10) {
                    price = price * 0.70;
                } else if (days >= 10 && days <= 15) {
                    price = price * 0.65;

                } else {
                    price = price / 2;
                }
                break;
            case "president apartment":
                price = nights * 35;
                if (days < 10) {
                    price = price * 0.90;
                } else if (days >= 10 && days <= 15) {
                    price = price * 0.85;
                } else {
                    price = price * 0.80;
                }
                break;
        }
        if (grade.equals("positive")) {
            price = price * 1.25;
        } else if (grade.equals("negative")) {
            price = price * 0.90;
        }
        System.out.printf("%.2f", price);
    }
}