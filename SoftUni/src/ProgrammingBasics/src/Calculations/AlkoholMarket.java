package Calculations;

import java.util.Scanner;

public class AlkoholMarket {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            Double whiskeyPrice = Double.parseDouble(scanner.nextLine());
            Double colBeer = Double.parseDouble(scanner.nextLine());
            Double colWine = Double.parseDouble(scanner.nextLine());
            Double colRakia = Double.parseDouble(scanner.nextLine());
            Double colWhiskey = Double.parseDouble(scanner.nextLine());

            double rakiaPrice = whiskeyPrice / 2;
            double winePrice = rakiaPrice * 0.60;
            double beerPrice = rakiaPrice * 0.20;

            double totalPrice = (whiskeyPrice * colWhiskey) + (colBeer * beerPrice) + (colWine * winePrice)
                    + (colRakia * rakiaPrice);

            System.out.printf("%.2f",totalPrice);
        }

}
