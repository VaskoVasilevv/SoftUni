package Exam;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());
        int top = 0;
        int sredni = 0;
        int low = 0;
        int fail = 0;
        double average = 0;

        for (int i = 1; i <= students; i++) {
            double grade = Double.parseDouble(scanner.nextLine());

            if (grade >= 2 && grade <= 2.99) {
                fail++;
                average += grade;
            } else if (grade >= 3 && grade <= 3.99) {
                low++;
                average += grade;

            } else if (grade >= 4 && grade <= 4.99) {
                sredni++;
                average += grade;

            } else {
                top++;
                average += grade;

            }

        }
        double sum = average / students;
        System.out.printf("Top Abstraction.Lab.PiontInRectangele.students: %.2f%%%n", top * 1.0 / students * 100);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", sredni * 1.0 / students * 100);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", low * 1.0 / students * 100);
        System.out.printf("Fail: %.2f%%%n", fail * 1.0 / students * 100);
        System.out.printf("Average: %.2f", sum);

    }
}
