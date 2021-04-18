package ProgrammingBasics.Exam;

import java.util.Scanner;

public class SuitcasesLoad05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double bagadge = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();

        int couneter = 0;
        double cufatotal = 0;

        while (!input.equals("End")) {
           double cufar = Double.parseDouble(input);
            cufatotal += cufar;
            if (couneter % 3 == 0){
                cufar += cufar * 0.1;
            }

            couneter ++;
            if (cufatotal > bagadge){
                break;
            }
            input = scanner.nextLine();
        }
        double end = bagadge - cufatotal;
        if (cufatotal < bagadge) {
            System.out.printf("Congratulations! All suitcases are loaded!%n");
            System.out.printf("Statistic: %d suitcases loaded.",couneter);
        }else {
            System.out.println("No more space!");
            System.out.printf("Statistic: %d suitcases loaded.",couneter);

        }
    }
}
