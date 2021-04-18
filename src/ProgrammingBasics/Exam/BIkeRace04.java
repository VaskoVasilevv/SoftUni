package ProgrammingBasics.Exam;

import java.util.Scanner;

public class BIkeRace04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int vllo = Integer.parseInt(scanner.nextLine());
        int starshivello = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        double juniors = 0;
        double seniors = 0;

        switch (input) {
            case "trail":
                juniors = vllo * 5.50;
                seniors = starshivello * 7;
                break;
            case "cross-country":
                juniors = vllo * 8;
                seniors = starshivello * 9.50;
                break;
            case "downhill":
                juniors = vllo * 12.25;
                seniors = starshivello * 13.75;
                break;
            case "road":
                juniors = vllo * 20;
                seniors = starshivello * 21.50;
                break;
        }
        double price = juniors + seniors;
        if (input.equals("cross-country")) {
            if (vllo + starshivello >= 50) {
                price = price - price * 0.25;
            }

        }
        price = price - price * 0.05;

        System.out.printf("%.2f", price);
    }
}
