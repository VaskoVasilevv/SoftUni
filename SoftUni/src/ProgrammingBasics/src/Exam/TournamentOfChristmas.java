package Exam;

import java.util.Scanner;

public class TournamentOfChristmas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());

        double money = 0;
        double daywon = 0;
        double daylose = 0;

        for (int i = 1; i <= days; i++) {
            String input = scanner.nextLine();
            int wincounter = 0;
            int losecounter = 0;
            double dailiMOney = 0;
            while (!input.equals("Finish")) {


                switch (input) {
                    case "win":
                        dailiMOney = dailiMOney + 20;
                        wincounter++;
                        break;
                    case "lose":
                        losecounter++;
                        break;
                }
                input = scanner.nextLine();
            }
            if (wincounter > losecounter) {
                dailiMOney = dailiMOney + dailiMOney * 0.1;
                daywon++;
            } else {
                daylose++;
            }
            money = money + dailiMOney;
        }
        if (daywon > daylose) {
            money = money + money * 0.2;
            System.out.printf("You won the tournament! Total raised money: %.2f", money);
        } else {
            System.out.printf("You lost the tournament! Total raised money: %.2f", money);
        }
    }
}
