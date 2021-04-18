package Fundamentals.Basyc.Syntax;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double totalMoney = 0;

        while (!input.equals("Start")) {
            double currentCoins = Double.parseDouble(input);
            if (currentCoins == 0.1 || currentCoins == 0.2 || currentCoins == 0.5 || currentCoins == 1 || currentCoins == 2) {
                totalMoney += currentCoins;
            } else {
                System.out.printf("Cannot accept %.2f%n", currentCoins);
            }

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("End")) {
            switch (input) {
                case "Nuts":
                    if (totalMoney >= 2){
                        totalMoney -= 2;
                        System.out.printf("Purchased %s%n",input);
                    }else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Water":
                    if (totalMoney >= 0.7){
                        totalMoney -= 0.7;
                        System.out.printf("Purchased %s%n",input);
                    }else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Crisps":
                    if (totalMoney >= 1.5){
                        totalMoney -= 1.5;
                        System.out.printf("Purchased %s%n",input);
                    }else {
                        System.out.println("Sorry, not enough money");
                    }

                    break;
                case "Soda":
                    if (totalMoney >= 0.8){
                        totalMoney -= 0.8;
                        System.out.printf("Purchased %s%n",input);
                    }else {
                        System.out.println("Sorry, not enough money");
                    }

                    break;
                case "Coke":
                    if (totalMoney >= 1){
                        totalMoney -= 1;
                        System.out.printf("Purchased %s%n",input);
                    }else {
                        System.out.println("Sorry, not enough money");
                    }

                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Change: %.2f%n",totalMoney);
    }
}
