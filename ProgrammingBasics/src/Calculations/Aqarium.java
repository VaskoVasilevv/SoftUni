package Calculations;

import java.util.Scanner;

public class Aqarium {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());

        int obem = a * b * c;
        double obshtObem = obem * 0.001;
        double procent = percent * 0.01;
        double litri = obshtObem * (1 - procent);

        System.out.printf("%.3f%n",litri);
    }
}
