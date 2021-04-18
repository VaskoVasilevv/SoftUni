package ProgrammingBasics.NestedLoops;

import java.util.Scanner;

public class Balls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int red = 0;
        int orange = 0;
        int yellow = 0;
        int white = 0;
        int black = 0;
        int totalPoints = 0;
        int outhers = 0;
        for (int i = 0; i < n; i++) {
            String color = scanner.nextLine();
            switch (color) {
                case "red":
                    totalPoints += 5;
                    red++;
                    break;
                case "orange":
                    totalPoints += 10;
                    orange++;
                    break;
                case "yellow":
                    totalPoints += 15;
                    yellow ++;
                    break;
                case "white":
                    totalPoints += 20;
                    white++;
                    break;
                case "black":
                    totalPoints = totalPoints / 2;
                    black++;
                    break;
                default:
                    outhers++;
                    break;
            }
        }
        System.out.printf("Total points: %d%n",totalPoints);
        System.out.printf("Points from red balls: %d%n",red);
        System.out.printf("Points from orange balls: %d%n",orange);
        System.out.printf("Points from yellow balls: %d%n",yellow);
        System.out.printf("Points from white balls: %d%n",white);
        System.out.printf("Other colors picked: %d%n",outhers);
        System.out.printf("Divides from black balls: %d",black);
    }
}
