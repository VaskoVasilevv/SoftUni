package Exam;

import java.util.Scanner;

public class CelsiusToFahrenheit01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double celsius = Double.parseDouble(scanner.nextLine());

        double result = celsius * 9/5 + 32;

        System.out.printf("%.2f ",result);
    }
}
