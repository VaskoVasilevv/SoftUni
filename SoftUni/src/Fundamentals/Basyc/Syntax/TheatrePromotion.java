package bg.softuni.fundamentals.Basyc.Syntax;

import java.util.Scanner;

public class TheatrePromotion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String day = scanner.nextLine();
        int age = scanner.nextInt();
        int price = 0;

        switch (day){
            case "Weekday":
                if (0 <= age && age <= 18){
                    price = 12;
                }else if (18 < age && age <= 64){
                    price = 18;
                }else  if (64 < age && age <= 122){
                    price = 12;
                }
                break;
            case "Weekend":
                if (0 <= age && age <= 18){
                    price = 15;
                }else if (18 < age && age <= 64){
                    price = 20;
                }else  if (64 < age && age <= 122){
                    price = 15;
                }
                break;
            case "Holiday":
                if (0 <= age && age <= 18){
                    price = 5;
                }else if (18 < age && age <= 64){
                    price = 12;
                }else  if (64 < age && age <= 122){
                    price = 10;
                }
                break;
        }
        if (price != 0) {
            System.out.printf("%d$", price);
        }else {
            System.out.println("Error!");
        }
    }
}
