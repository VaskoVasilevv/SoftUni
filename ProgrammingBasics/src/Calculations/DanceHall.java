package Calculations;

import java.util.Scanner;

public class DanceHall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Double L = Double.parseDouble(scanner.nextLine());
        Double W = Double.parseDouble(scanner.nextLine());
        Double side = Double.parseDouble(scanner.nextLine());

        double dancehall = (L * 100) * (W * 100);
        double warderobe = (side * 100) * (side * 100);
        double peika = dancehall / 10;
        dancehall = dancehall - (warderobe + peika);

        double numberofdancers = Math.floor(dancehall / 7040)  ;

        System.out.printf("%.0f",numberofdancers);
    }
}
