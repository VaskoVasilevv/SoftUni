package ProgrammingBasics.Exam;

import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int period = Integer.parseInt(scanner.nextLine());
        int Trated = 0;
        int Untrated = 0;

        for (int i = 1; i <= period; i++) {
            int days = Integer.parseInt(scanner.nextLine());
            int doctor = 7;
            if (i % 3 == 0 && Untrated > Trated) {
                doctor += 1;
            }
            if (days > doctor){
                Untrated += days - doctor;
                Trated += doctor;
            }else {
                Trated += days;
            }
        }
        System.out.printf("Treated patients: %d.%n", Trated);
        System.out.printf("Untreated patients: %d.", Untrated);
    }
}
