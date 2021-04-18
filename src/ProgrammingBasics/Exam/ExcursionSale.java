package ProgrammingBasics.Exam;

import java.util.Scanner;

public class ExcursionSale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int seapaket = Integer.parseInt(scanner.nextLine());
        int mountainpaket = Integer.parseInt(scanner.nextLine());
        int pechalba = 0;

        String vid = "";

        while (!vid.equals("Stop")) {
            if (seapaket <= 0 && mountainpaket <= 0) {
                System.out.println("Good job! Everything is sold.");
                break;
            }
            vid = scanner.nextLine();
            switch (vid) {
                case "sea":
                    if (seapaket == 0) {
                        pechalba = pechalba;
                    } else {
                        pechalba += 680;
                        seapaket--;
                    }

                    break;
                case "mountain":
                    if (mountainpaket == 0){
                        pechalba = pechalba;
                    }else {
                        pechalba += 499;
                        mountainpaket--;
                    }
                    break;
            }

        }
        System.out.printf("Profit: %d leva.", pechalba);
    }
}
