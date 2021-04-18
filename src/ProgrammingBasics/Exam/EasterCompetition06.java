package ProgrammingBasics.Exam;

import java.util.Scanner;

public class EasterCompetition06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int broiKozunaci = Integer.parseInt(scanner.nextLine());
        int maxChefGrades = Integer.MIN_VALUE;
        String gradeAzString = "";
        String topShef = "";

        for (int i = 1; i <= broiKozunaci; i++) {
            String nameOfBaker = scanner.nextLine();
            gradeAzString = scanner.nextLine();
            int sumGrades = 0;

            while (!"Stop".equals(gradeAzString)) {
                int ocenka = Integer.parseInt(gradeAzString);
                sumGrades += ocenka;
                if (ocenka <= 0 || ocenka > 10) {
                    gradeAzString = scanner.nextLine();
                    continue;
                }
                gradeAzString = scanner.nextLine();
            }
            System.out.printf("%s has %d points.%n", nameOfBaker,sumGrades);

            if (sumGrades > maxChefGrades){
                maxChefGrades = sumGrades;
                topShef = nameOfBaker;
                System.out.printf("%s is the new number 1!%n",topShef);
            }
        }
        System.out.printf("%s won competition with %d points!",topShef,maxChefGrades);
    }
}
