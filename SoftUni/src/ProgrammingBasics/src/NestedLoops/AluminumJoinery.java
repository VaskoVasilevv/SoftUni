package NestedLoops;

import java.util.Scanner;

public class AluminumJoinery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int broi = Integer.parseInt(scanner.nextLine());
        String vidDograma = scanner.nextLine();
        String delivery = scanner.nextLine();
        double price = 0;


        switch (vidDograma) {
            case "90X130":
                price =  110 * broi;
                if (broi > 60){
                    price = price - price * 0.08;
                }else if (broi > 30){
                    price = price - price* 0.05;
                }
                break;
            case "100X150":
                price = 140 * broi;
                if (broi > 80){
                    price = price - price * 0.10;
                }else if (broi > 40){
                    price = price - price * 0.06;
                }
                break;
            case "130X180":
                price = 190 * broi;
                if (broi > 50){
                    price = price - price * 0.12;
                }else if (broi > 20){
                    price = price - price * 0.07;
                }
                break;
            case "200X300":
                price = 250 * broi;
                if (broi > 50){
                    price = price - price * 0.14;
                }else if (broi > 25){
                    price = price - price * 0.09;
                }
                break;

        }
        if (delivery.equals("With delivery" )){
            price = price + 60;
        }
        if (broi > 99){
            price = price - price * 0.04;
        }
        if (broi < 10){
            System.out.println("Invalid order");
        }else {
            System.out.printf("%.2f BGN", price);
        }
    }
}
