package MidEXAM;

import java.util.Scanner;

public class E01BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());
        int lectureCount = Integer.parseInt(scanner.nextLine());
        int bonus = Integer.parseInt(scanner.nextLine());

        double maxBonus = 0;
        int attended = 0;
        for (int i = 0; i < students; i++) {
            int attendance = Integer.parseInt(scanner.nextLine());
            double totalBonus = attendance / (double) lectureCount * (5 + bonus);
            if (maxBonus <= totalBonus && attended <= attendance){
                maxBonus = totalBonus;
                attended = attendance;
            }


        }
        System.out.printf("Max Bonus: %.0f.%n",maxBonus);
        System.out.printf("The student has attended %d lectures.",attended);

    }
}
