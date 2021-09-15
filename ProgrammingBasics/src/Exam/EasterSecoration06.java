package Exam;

import java.util.Scanner;

public class EasterSecoration06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int broiKlienti = Integer.parseInt(scanner.nextLine());
        double end = 0;

        for (int i = 1; i <= broiKlienti; i++) {
            String input = scanner.nextLine();
            int productCounter = 0;
            double sum = 0.0;
            while (!input.equals("Finish")) {
                productCounter++;
                switch (input) {
                    case "basket":
                        sum += 1.50;
                        break;
                    case "wreath":
                        sum += 3.80;
                        break;
                    case "chocolate bunny":
                        sum += 7;
                        break;
                }


                input = scanner.nextLine();
            }
            if (productCounter % 2 == 0){
                sum = sum - sum * 0.2;
            }
            end = end + sum;
            System.out.printf("You purchased %d items for %.2f leva.%n",productCounter,sum);
        }
        System.out.printf("Average bill per client is: %.2f leva.",end / broiKlienti);
    }
}
