package Exam;

import java.util.Scanner;

public class CareOfPuppy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int food = Integer.parseInt(scanner.nextLine());
        String foodForDog = scanner.nextLine();
        int dogEatenGr = food * 1000 ;
        int foodGr = 0;
        int totalEatenFood = 0;
        int sum = 0;

        while (!foodForDog.equals("Adopted")){
            int dogEatenInGr = Integer.parseInt(foodForDog);
            totalEatenFood += dogEatenInGr;
            foodForDog = scanner.nextLine();
        }
        sum = totalEatenFood - dogEatenGr;
        if (totalEatenFood <= dogEatenGr){
            System.out.printf("Food is enough! Leftovers: %d grams.",Math.abs(sum));
        }else {
            System.out.printf("Food is not enough. You need %d grams more." ,Math.abs(sum));
        }
    }
}
