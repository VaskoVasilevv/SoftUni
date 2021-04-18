package ProgrammingBasics.Exam;

import java.util.Scanner;

public class FootballTournament05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());
        int w = 0;
        int d = 0;
        int l = 0;

        int points = 0;
        for (int i = 1; i <= n; i++) {

            String a = scanner.nextLine();

            switch (a) {
                case "W":
                    points += 3;
                    w++;
                    break;
                case "D":
                    points += 1;
                    d++;
                    break;
                case "L":
                    l++;
                    break;
            }
        }
        int totalPoints = w + d + l;
        double win = w * 1.0 / n * 100;
        if (n == 0){
            System.out.printf("%s hasn't played any games during this season.",input);
        }else {
            System.out.printf("%s has won %d points during this season.%n",input,points);
            System.out.println("Total stats:");
            System.out.printf("## W: %d%n",w);
            System.out.printf("## D: %d%n",d);
            System.out.printf("## L: %d%n",l);
            System.out.printf("Win rate: %.2f%%",win);
        }

    }
}

