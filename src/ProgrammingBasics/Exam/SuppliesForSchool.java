package ProgrammingBasics.Exam;

import java.util.Scanner;

public class SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pencil = Integer.parseInt(scanner.nextLine());
        int markers = Integer.parseInt(scanner.nextLine());
        double preparat = Double.parseDouble(scanner.nextLine());
        int percent = Integer.parseInt(scanner.nextLine());

        double result = pencil * 5.8 + markers * 7.2 + preparat * 1.2 ;
        double resultWithPercent = result - (result * percent/100);

        System.out.printf("%.3f",resultWithPercent);
    }
}
