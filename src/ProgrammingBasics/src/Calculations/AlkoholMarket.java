package Calculations;

import java.util.Scanner;

public class AlkoholMarket {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        double whiskeyPrice = Double.parseDouble(scanner.nextLine());
        double colBeer = Double.parseDouble(scanner.nextLine());
        double colWine = Double.parseDouble(scanner.nextLine());
        double colRakia = Double.parseDouble(scanner.nextLine());
        double colWhiskey = Double.parseDouble(scanner.nextLine());

        double rakiaPrice = whiskeyPrice / 2;
        double winePrice = rakiaPrice * 0.60;
        double beerPrice = rakiaPrice * 0.20;

        double totalPrice = (whiskeyPrice * colWhiskey) + (colBeer * beerPrice) + (colWine * winePrice)
                + (colRakia * rakiaPrice);

        System.out.printf("%.2f", totalPrice);
    }
}


