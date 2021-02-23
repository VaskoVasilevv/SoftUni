package Abstraction.holiday;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String [] tokens = input.split("\\s+");

        PriceCalculator calculator = new PriceCalculator(Double.parseDouble(tokens[0]),Integer.parseInt( tokens[1])
                ,DiscountType.valueOf(tokens[3].toLowerCase())
                ,Season.valueOf(tokens[3].toUpperCase()));

        System.out.println("");
    }
}
