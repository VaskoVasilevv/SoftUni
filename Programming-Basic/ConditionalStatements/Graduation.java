import java.util.Scanner;

public class Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String studentName = scanner.nextLine();
        double average = 0;
        int grade = 1;
        while (grade <= 12){
            double gradeRating = Double.parseDouble(scanner.nextLine());

            if (gradeRating >=4){
                grade++;
                average += gradeRating;
            }
        }
        average /= 12;
        System.out.printf("%s graduated. Average grade: %.2f",studentName , average);

    }
}
