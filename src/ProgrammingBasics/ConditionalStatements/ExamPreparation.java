package ProgrammingBasics.ConditionalStatements;

import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int maxCountPoorGrades = Integer.parseInt(scanner.nextLine());
        int gradeSum = 0;
        int gradesCount = 0;
        String lastProblmNamme = "";
        int poorGradeCounter = 0;

        String input = scanner.nextLine();
        while (!"Enough".equals(input)) {
            String problemName = input;
            int grade = Integer.parseInt(scanner.nextLine());
            gradeSum += grade;
            gradesCount++;
            lastProblmNamme = problemName;

            if (grade <= 4){
                poorGradeCounter++;
                if (poorGradeCounter == maxCountPoorGrades){
                    break;
                }
            }
            input = scanner.nextLine();

        }
        if (poorGradeCounter == maxCountPoorGrades){
            System.out.printf("You need a break, %d poor grades.", poorGradeCounter);
        }else {
            double avgScore = gradeSum * 1.0 / gradesCount;
            System.out.printf("Average score: %.2f%n", avgScore);
            System.out.printf("Number of problems: %d%n", gradesCount);
            System.out.printf("Last problem: %s", lastProblmNamme);
        }
    }
}
