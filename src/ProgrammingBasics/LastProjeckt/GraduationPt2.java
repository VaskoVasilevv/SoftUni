package ProgrammingBasics.LastProjeckt;

import java.util.Scanner;

public class GraduationPt2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String studentName = scanner.nextLine();

        double average = 0;
        int grade = 1;
        int failCounter = 0;

        boolean exploaded = false;

        while (grade <= 12){
            double gradeRating = Double.parseDouble(scanner.nextLine());

            if (gradeRating >=4){
                grade++;
                average += gradeRating;
            }else {
                failCounter++;
                if (failCounter == 2){
                    exploaded = true;
                    break;
                }
            }
        }
        if (exploaded ) {
            System.out.printf("%s has been excluded at %d grade", studentName, grade);
        }else {
            average /= 12;
            System.out.printf("%s graduated. Average grade: %.2f", studentName, average);
        }
    }
}
