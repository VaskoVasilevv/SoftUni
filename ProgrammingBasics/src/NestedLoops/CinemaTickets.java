package NestedLoops;

import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();   //Taxi
        int standartCounter = 0;
        int studentCounter = 0;
        int kidCounter = 0;

        while (!input.equals("Finish")) {
            int seatsCnt = Integer.parseInt(scanner.nextLine());
            int peopleCounter = 0;
            for (int i = 0; i < seatsCnt; i++) {
                String ticketType = scanner.nextLine();
                if (ticketType.equals("End")) {
                    break;
                }
                peopleCounter++;
                switch (ticketType) {
                    case "student":
                        studentCounter++;
                        break;
                    case "standard":
                        standartCounter++;
                        break;
                    case "kid":
                        kidCounter++;
                        break;
                }
            }
            double percent = peopleCounter * 1.0 / seatsCnt * 100;
            System.out.printf("%s - %.2f%% full.%n",input,percent);

            input = scanner.nextLine();
        }
        int peopleCounter = studentCounter + standartCounter + kidCounter;
        System.out.printf("Total tickets: %d%n",peopleCounter);
        System.out.printf("%.2f%% student tickets.%n",studentCounter * 1.0 / peopleCounter * 100);
        System.out.printf("%.2f%% standard tickets.%n",standartCounter * 1.0/ peopleCounter * 100);
        System.out.printf("%.2f%% kids tickets.%n",kidCounter * 1.0 / peopleCounter * 100);
    }
}
