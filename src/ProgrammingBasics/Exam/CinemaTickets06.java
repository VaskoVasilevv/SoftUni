package ProgrammingBasics.Exam;

import java.util.Scanner;

public class CinemaTickets06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int studentCounter = 0;
        int standardCounter = 0;
        int kidCounter = 0;
        while (!"Finish".equals(input)) {
            int freePlaces = Integer.parseInt(scanner.nextLine());
            int totalCounter = 0;
            for (int i = 0; i < freePlaces; i++) {
                String type  = scanner.nextLine();
                if (type.equals("End")) {
                    break;
                }
                totalCounter++;
                switch (type) {
                    case "student":
                        studentCounter++;
                        break;
                    case "standard":
                        standardCounter++;
                        break;
                    case "kid":
                        kidCounter++;
                        break;
                }


            }
            double totalResult = totalCounter * 1.0 / freePlaces * 100;
            System.out.printf("%s - %.2f%% full.%n",input,totalResult);
            input = scanner.nextLine();
        }
        double total = standardCounter + studentCounter + kidCounter;
        System.out.printf("Total tickets: %.0f%n",total);
        System.out.printf("%.2f%% student tickets.%n",studentCounter / total * 100);
        System.out.printf("%.2f%% standard tickets.%n",standardCounter / total * 100);
        System.out.printf("%.2f%% kids tickets.%n",kidCounter / total * 100);
    }
}