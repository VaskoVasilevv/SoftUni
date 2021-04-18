package Exam;

import java.util.Scanner;

public class MountainRun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double seconds = Double.parseDouble(scanner.nextLine());
        double metri = Double.parseDouble(scanner.nextLine());
        double time = Double.parseDouble(scanner.nextLine());

        double toend = metri * time;
        double timeWhitDelay = Math.floor(metri / 50) * 30;
        double totoalTime = toend + timeWhitDelay;


        if (totoalTime < seconds){
            System.out.printf("Yes! The new record is %.2f seconds.",totoalTime);
        }else {
            double end = totoalTime - seconds;
            System.out.printf("No! He was %.2f seconds slower.",end);
        }
    }
}
