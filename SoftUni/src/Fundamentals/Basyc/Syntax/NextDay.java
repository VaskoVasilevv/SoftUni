package bg.softuni.fundamentals.Basyc.Syntax;

import java.util.Scanner;

public class NextDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int year = Integer.parseInt(scanner.nextLine());
        int month = Integer.parseInt(scanner.nextLine());
        int day = Integer.parseInt(scanner.nextLine());

        day ++;
        if (day >= 30){
            day-= 30;
            month++;
            if (month>=12){
                month -= 12;
                year++;
            }
        }

        System.out.printf("%d-%d-%d",year,month,day);
    }
}
