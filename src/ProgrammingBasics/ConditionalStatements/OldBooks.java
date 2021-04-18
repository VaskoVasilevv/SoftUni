package ProgrammingBasics.ConditionalStatements;

import java.util.Scanner;

public class OldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int broiNezadovolitelni = Integer.parseInt(scanner.nextLine());
        int falseCounter = 0;
        int resheni = 0;
        String last = "";
        int average = 0;
        String input = scanner.nextLine();
        while (!input.equals("Enough")) {
            String ccurent = input;
            int courentGrade = Integer.parseInt(scanner.nextLine());
            average += courentGrade;
            resheni++;
            last = input;
            if (courentGrade <= 4) {
                falseCounter++;
                if (broiNezadovolitelni == falseCounter) {
                    break;
                }
            }
            input = scanner.nextLine();
        }
        if (broiNezadovolitelni == falseCounter) {
            System.out.printf("You need a break, %d poor grades.", falseCounter);
        } else {
            double average1 = average * 1.0 / resheni;
            System.out.printf("Average score: %.2f%n", average1);
            System.out.printf("Number of problems: %d%n", resheni);
            System.out.printf("Last problem: %s", last);
        }
    }
}
