package MidEXAM;

import java.util.Scanner;

public class E01EasterCozonacs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double flor = Double.parseDouble(scanner.nextLine());

        double eggPrice = flor * 0.75;
        double milk = flor * 1.25;
        double milkForOneCozonak = milk / 4;
        double totalPrice = flor + eggPrice + milkForOneCozonak;
        int counter = 0;
        int coloredEgs = 0;
        while (budget >= totalPrice){
            budget -= totalPrice;
            counter ++;
            coloredEgs+=3;
            if (counter % 3 == 0){
              coloredEgs -=  counter -2;
            }

        }
        System.out.printf("You made %d cozonacs! Now you have %d eggs and %.2fBGN left.",counter,coloredEgs,budget);

    }
}
