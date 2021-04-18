package Exam;

import java.util.Scanner;

public class GameOfIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int input = Integer.parseInt(scanner.nextLine());
        double tochki = 0;
        int to9 = 0;
        int to19 = 0;
        int to29 = 0;
        int to39 = 0;
        int to50 = 0;
        int invalid = 0;

        for (int i = 1; i <= input; i++) {
            double forTurn = Double.parseDouble(scanner.nextLine());

            if (forTurn >= 40 && forTurn <= 50) {
                tochki += 100;
                to50++;
            } else if (forTurn >= 30 && forTurn < 40) {
                tochki += 50;
                to39++;
            }else if (forTurn >= 20 && forTurn < 30){
                tochki = tochki + forTurn * 0.40;
                to29++;
            }else if (forTurn >= 10 && forTurn < 20){
                tochki = tochki + forTurn * 0.30;
                to19++;
            }else if (forTurn >= 0 && forTurn < 10){
                tochki = tochki + forTurn * 0.20;
                to9++;
            }else {
                tochki /= 2;
                invalid ++;
            }

        }
        System.out.printf("%.2f%n",tochki);
        System.out.printf("From 0 to 9: %.2f%%%n",to9 * 1.0 /input * 100);
        System.out.printf("From 10 to 19: %.2f%%%n",to19 * 1.0 /input * 100);
        System.out.printf("From 20 to 29: %.2f%%%n",to29 * 1.0 /input * 100);
        System.out.printf("From 30 to 39: %.2f%%%n",to39 * 1.0 /input * 100);
        System.out.printf("From 40 to 50: %.2f%%%n",to50 * 1.0 /input * 100);
        System.out.printf("Invalid numbers: %.2f%%",invalid * 1.0 /input * 100);
    }
}
