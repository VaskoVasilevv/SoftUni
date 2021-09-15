package Calculations;

import java.util.Scanner;

public class YardGreening {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double prise = Double.parseDouble(scanner.nextLine());

        double a = prise * 7.61;
        double b = 0.18 * a;
        double finaleprise = a - b;

        System.out.printf("The final price is: %.2f lv. %n", finaleprise);
        System.out.printf("The discount is: %.2f lv.", b);


    }
}
