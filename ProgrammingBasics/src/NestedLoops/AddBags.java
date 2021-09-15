package NestedLoops;

import java.util.Scanner;

public class AddBags {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceForBagadge = Double.parseDouble(scanner.nextLine());
        double kgBagadge = Double.parseDouble(scanner.nextLine());
        int daysToTravel = Integer.parseInt(scanner.nextLine());
        int broiBagadge = Integer.parseInt(scanner.nextLine());
        double cenazaBagaj = 0;

        if (kgBagadge < 10){
            cenazaBagaj = priceForBagadge * 0.2;
        }else if (kgBagadge <=20){
            cenazaBagaj = priceForBagadge / 2 ;
        }else {
            cenazaBagaj = priceForBagadge;
        }
        if (daysToTravel > 30){
            cenazaBagaj =  cenazaBagaj  + cenazaBagaj* 0.1;
        }else if (daysToTravel >= 7 && daysToTravel <= 30){
            cenazaBagaj =  cenazaBagaj + cenazaBagaj * 0.15;
        }else if (daysToTravel < 7){
            cenazaBagaj = cenazaBagaj + cenazaBagaj * 0.4;
        }
        double end = cenazaBagaj * broiBagadge;
        System.out.printf("The total price of bags is: %.2f lv. ",end);
    }
}
