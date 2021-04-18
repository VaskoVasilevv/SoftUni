package Fundamentals.Methods;

import java.util.Scanner;

public class TopNumberEX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n ; i++) {
            if (divisibleByEight(i) && oddDigit(i)){
                System.out.println(i);
            }

        }

    }
    public static boolean divisibleByEight (int n){
        int sum = 0;

        while (n > 0){
            sum += n % 10;
            n /= 10;
        }
        if (sum % 8 == 0){
            return true;
        }else{
            return false;
        }
    }
    public static boolean oddDigit (int n){
        int counter = 0;

        while (n > 0){
            if ((n % 10) % 2 != 0){
                counter ++;
            }
            n /= 10;
        }
        if (counter >= 1){
            return true;
        }else {
            return false;
        }
    }
}
