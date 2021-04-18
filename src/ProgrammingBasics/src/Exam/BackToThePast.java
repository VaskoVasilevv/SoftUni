package Exam;

import java.util.Scanner;

public class BackToThePast {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        int yearToLive = Integer.parseInt(scanner.nextLine());
        int ivan = 18;
        boolean flag = false;

        for (int i = 1800; i <= yearToLive ; i++) {
            if (i % 2 == 0){
                money -= 12000;
            }else {
                money -= 12000 + ivan * 50;
            }
            ivan ++;

        }
        if (money < 0){
            System.out.printf("He will need %.2f dollars to survive.",Math.abs(money));
        }else {
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.",money);
        }
    }
}
