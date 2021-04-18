package NestedLoops;

import java.util.Scanner;

public class Fooddelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double fuel = Double.parseDouble(scanner.nextLine());
        String day = scanner.nextLine();
        double finalPrice = 0;
        double priceForFuel = fuel * 2.10 ;
        double withGuide = priceForFuel + 100;

        if (day.equals("Saturday") ){
                finalPrice  = withGuide * 0.9;

        }else {
            finalPrice = 0.8 * withGuide;
        }
        if (finalPrice > budget){
            System.out.printf("Not enough money! Money needed: %.2f lv.",finalPrice - budget);
        }else {
            System.out.printf("Safari time! Money left: %.2f lv.",budget - finalPrice);
        }

    }
}

