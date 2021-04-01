package Exam;

import java.util.Scanner;

public class CoffeeMachine03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String drimk = scanner.nextLine();
        String vid = scanner.nextLine();
        int broi = Integer.parseInt(scanner.nextLine());
        double price = 0;

        switch (drimk) {
            case "Espresso":
                switch (vid) {
                    case "Without":
                        price += 0.90;
                        break;
                    case "Normal":
                        price += 1;
                        break;
                    case "Extra":
                        price += 1.20;
                        break;

                }
                break;
            case "Cappuccino":
                switch (vid) {
                    case "Without":
                        price += 1;
                        break;
                    case "Normal":
                        price += 1.20;
                        break;
                    case "Extra":
                        price += 1.60;
                        break;

                }
                break;
            case "Tea":
                switch (vid) {
                    case "Without":
                        price += 0.50;
                        break;
                    case "Normal":
                        price += 0.60;
                        break;
                    case "Extra":
                        price += 0.70;
                        break;

                }
                break;
        }
        double total = price * broi;
        if (vid.equals("Without")){
            total -= total * 0.35;
        }
        if (drimk.equals("Espresso") && broi >= 5) {
            total -= total * 0.25;

        }
        if (total >= 15) {
            total -= total * 0.20;
        }
        System.out.printf("You bought %d cups of %s for %.2f lv.", broi, drimk, total);
    }
}
