package NestedLoops;

import java.util.Scanner;

public class Traveling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double budget = Double.parseDouble(scanner.nextLine());
        boolean end = false;


        for (double i = 0; i <= budget; i++) {

            double sum = Double.parseDouble(scanner.nextLine());
            i += sum;
            if (i >= budget) {
                System.out.printf("Going to %s!%n", input);
                i = 0;
                input = scanner.nextLine();
                if (input.equals("End")) {
                    break;
                }
                budget = Double.parseDouble(scanner.nextLine());
            }
        }
    }
}


