package bg.softuni.fundamentals.Methods;

import java.util.Scanner;

public class GradesLAB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printGrade(scanner.nextDouble());
    }

    static void printGrade(double number) {
        if (number >= 2 && number <= 6) {
            if (number < 3) {
                System.out.println("Fail");
            } else if (number < 3.5){
                System.out.println("Poor");
            } else if (number <4.5){
                System.out.println("Good");
            } else if (number < 5.5){
                System.out.println("Very good");
            } else {
                System.out.println("Excellent");
            }
        }
    }
}
