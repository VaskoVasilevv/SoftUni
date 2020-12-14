package bg.softuni.fundamentals.Basyc.Syntax;

import java.util.Scanner;

public class Vacantion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        String typeOfGroup = scanner.nextLine();
        String day = scanner.nextLine();
        double totalPrice = 0;

        switch (typeOfGroup) {
            case "Students":
                switch (day) {
                    case "Friday":
                        totalPrice = people * 8.45;
                        break;
                    case "Saturday":
                        totalPrice = people * 9.80;
                        break;
                    case "Sunday":
                        totalPrice = people * 10.46;
                        break;
                }
                if (people  >= 30 ){
                    totalPrice *= 0.85;
                }
                break;
            case "Business":
                double currentPrice = 0;
                switch (day) {
                    case "Friday":
                        currentPrice = 10.90;
                        totalPrice = people * 10.90;
                        break;
                    case "Saturday":
                        currentPrice = 15.60;
                        totalPrice = people * 15.60;
                        break;
                    case "Sunday":
                        totalPrice = people * 16;
                        break;
                }
                if (people >= 100){
                    totalPrice  -= (currentPrice * 10);
                }
                break;
            case "Regular":
                switch (day) {
                    case "Friday":
                        totalPrice = people * 15;
                        break;
                    case "Saturday":
                        totalPrice = people * 20;
                        break;
                    case "Sunday":
                        totalPrice = people * 22.50;
                        break;
                }
                if (people >= 10 && people <= 20){
                    totalPrice *= 0.95;
                }
                break;
        }
        System.out.printf("Total price: %.2f",totalPrice);

    }
}
