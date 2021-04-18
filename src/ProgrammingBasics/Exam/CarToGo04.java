package ProgrammingBasics.Exam;

import java.util.Scanner;

public class CarToGo04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budged = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        double budged1 = 0;
        if (budged <= 100) {
            System.out.println("Economy class");
            switch (input) {
                case "Summer":
                    budged1 = budged * 0.35;
                    System.out.printf("Cabrio - %.2f",budged1);
                    break;
                case "Winter":
                    budged1 = budged * 0.65;
                    System.out.printf("Jeep - %.2f",budged1);
                    break;

            }

        }else if (budged >100 && budged <= 500){
            System.out.println("Compact class");
            switch (input) {
                case "Summer":
                    budged1 = budged * 0.45;
                    System.out.printf("Cabrio - %.2f",budged1);
                    break;
                case "Winter":
                    budged1 = budged * 0.80;
                    System.out.printf("Jeep - %.2f",budged1);
                    break;
            }
        }else {
            budged1 = budged * 0.90;
            System.out.println("Luxury class");
            System.out.printf("Jeep - %.2f",budged1);

        }
    }
}
