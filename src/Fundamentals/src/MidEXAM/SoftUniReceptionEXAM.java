package MidEXAM;

import java.util.Scanner;

public class SoftUniReceptionEXAM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = scanner.nextInt() + scanner.nextInt() + scanner.nextInt();
        int studentsCount = Integer.parseInt(scanner.nextLine());

        int hours = 0;
        while (studentsCount > 0) {
            hours++;
            if (hours % 4 != 0) {
                studentsCount -= sum;
            }
        }
        System.out.printf("Time needed: %dh. ", hours);
    }
}
