package MidEXAM;

import java.util.Scanner;

public class E02MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rooms = scanner.nextLine().split("\\|+");


        int healthPoints = 100;
        int bitcoins = 0;
        boolean isStillAlive = true;
        int bestRoom = 0;

        for (int i = 0; i < rooms.length; i++) {
            String[] command = rooms[i].split(" ");
            bestRoom++;
            if (command[0].equals("chest")) {
                bitcoins += Integer.parseInt(command[1]);
                System.out.println("You found " + command[1] + " bitcoins.");
            } else if (command[0].equals("potion")) {
                if (healthPoints + Integer.parseInt(command[1]) >= 100) {
                    int healedPoints = 100 - healthPoints;
                    healthPoints = 100;
                    System.out.printf("You healed for %d hp.%n", healedPoints);
                    System.out.printf("Current health: %d hp.%n", healthPoints);
                } else {
                    healthPoints += Integer.parseInt(command[1]);
                    System.out.printf("You healed for %d hp.%n", Integer.parseInt(command[1]));
                    System.out.printf("Current health: %d hp.%n", healthPoints);
                }

            } else {
                if (healthPoints - Integer.parseInt(command[1]) > 0) {
                    System.out.printf("You slayed %s.%n", command[0]);
                    healthPoints -= Integer.parseInt(command[1]);
                } else {
                    System.out.printf("You died! Killed by %s.%n", command[0]);
                    System.out.printf("Best room: %d", bestRoom);
                    isStillAlive = false;
                    break;
                }
            }
        }
        if (isStillAlive){
            System.out.printf("You've made it!%n");
            System.out.printf("Bitcoins: %d%n", bitcoins);
            System.out.printf("Health: %d%n", healthPoints);
        }
    }
}
