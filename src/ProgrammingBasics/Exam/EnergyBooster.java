package ProgrammingBasics.Exam;

import java.util.Scanner;

public class EnergyBooster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String input = scanner.nextLine();
        int broi = Integer.parseInt(scanner.nextLine());
        double price = 0;
        //, "Mango", "Pineapple" или "Raspberry"
        switch (fruit) {
            case "Watermelon":
                if (input.equals("small")) {
                    price = 56 * 2 * broi;
                } else {
                    price = 28.7 * 5 * broi;
                }
                break;
            case "Mango":
                if (input.equals("small")) {
                    price = (36.66 * 2) * broi;
                } else {
                    price = 19.60 * 5 * broi;
                }
                break;
            case "Pineapple":
                if (input.equals("small")) {
                    price = (42.1 * 2) * broi;
                } else {
                    price = (24.8 * 5) * broi;
                }
                break;
            case "Raspberry":
                if (input.equals("small")) {
                    price = 20 * 2 * broi;
                } else {
                    price = 15.20 * 5 * broi;
                }
                break;
        }
        if (price >= 400 && price <= 1000) {
            price = price - price * 0.15;
        } else if (price > 1000){
            price = price / 2;
        }
        System.out.printf("%.2f lv.", price);
    }
}
