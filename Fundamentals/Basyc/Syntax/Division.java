package bg.softuni.fundamentals.Basyc.Syntax;

import java.util.Scanner;

public class Division {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int divider = 0;
        boolean flag = false;

        if (num % 10 == 0){
            divider = 10;
        }else if (num % 7 == 0){
            divider = 7;
        }else if (num % 6 == 0){
            divider = 6;
        }else if (num % 3 == 0){
            divider = 3;
        }else if (num % 2 == 0){
            divider = 2;
        }else {
            flag = true;
        }
        if (flag){
            System.out.println("Not divisible");
        } else {
            System.out.printf("The number is divisible by %d", divider);
        }
    }
}
