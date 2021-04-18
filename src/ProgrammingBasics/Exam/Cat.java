package ProgrammingBasics.Exam;

import java.util.Scanner;

public class Cat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double bedPrice = Double.parseDouble(scanner.nextLine());
        double wcPrice = Double.parseDouble(scanner.nextLine());


        double wc = wcPrice + wcPrice * 0.25;
        double bed = wc / 2;
        double veterinar = bed + bed * 0.1;

        double obshtRazzhod = (wcPrice + wc + bed + veterinar);
        double obsht = obshtRazzhod * 0.05;

        double forOneYear = bedPrice + 12 * obshtRazzhod + 12 * obsht;

        System.out.printf("%.2f lv.",forOneYear);

    }
}
