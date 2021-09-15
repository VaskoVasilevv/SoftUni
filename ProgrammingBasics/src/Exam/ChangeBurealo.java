package Exam;

import java.util.Scanner;

public class ChangeBurealo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bitcoins = Integer.parseInt(scanner.nextLine());
        double chiniseYoan = Double.parseDouble(scanner.nextLine());
        double comission = Double.parseDouble(scanner.nextLine());

        double USD = 1.76;
        double Euro = 1.95;
        double ChoniseYoan = chiniseYoan * (0.15 * USD);
        double comis = comission / 100;

        double result = bitcoins * 1168 + ChoniseYoan ;
        double evro = result / Euro;
        double resultWithComission = evro - evro * comis;

        System.out.printf("%.2f", resultWithComission);
    }
}
