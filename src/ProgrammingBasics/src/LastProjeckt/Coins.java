package LastProjeckt;

import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double change = Double.parseDouble(scanner.nextLine());
        double money =Math.floor(change * 100);
        int coins = 0;

        while (money > 0) {
            if (money - 200 >= 0) {
                money -= 200;
                coins++;
            } else if (money - 100 >= 0) {
                money -= 100;
                coins++;
            } else if (money - 50 >= 0) {
                money -= 50;
                coins++;
            } else if (money - 20 >= 0) {
                money -= 20;
                coins++;
            } else if (money - 10 >= 0) {
                money -= 10;
                coins++;
            } else if (money - 5 >= 0) {
                money -= 5;
                coins++;
            } else if (money - 2 >= 0) {
                money -= 2;
                coins++;
            } else if (money - 1 >= 0) {
                money -= 1;
                coins++;
            }
        }
        System.out.println(coins);
    }
}
