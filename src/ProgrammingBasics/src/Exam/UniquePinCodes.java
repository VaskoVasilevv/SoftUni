package Exam;

import java.util.Scanner;

public class UniquePinCodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // NE RABOTI 30 / 100 !!!


        int firsstDigit = Integer.parseInt(scanner.nextLine());
        int secondDigit = Integer.parseInt(scanner.nextLine());
        int thirdDigit = Integer.parseInt(scanner.nextLine());

        for (int i = 2; i < firsstDigit; i += 2) {
            for (int j = 2; j <= secondDigit ; j++) {
                for (int k = 2; k <= thirdDigit; k += 2) {
                    if (j == 2 || j == 3 || j == 5 || j == 7) {
                        System.out.println(i + " " + j + " " + k);
                    }
                }
            }
        }
    }
}
