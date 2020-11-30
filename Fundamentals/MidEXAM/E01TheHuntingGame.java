package bg.softuni.fundamentals.MidEXAM;

import java.util.Scanner;

public class E01TheHuntingGame {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int daysOfAdventure = Integer.parseInt(scanner.nextLine());
        int countOfPlayers = Integer.parseInt(scanner.nextLine());
        double groupEnergy = Double.parseDouble(scanner.nextLine());
        double waterPerDayForOnePerson = Double.parseDouble(scanner.nextLine());
        double foodPerDayForOnePerson = Double.parseDouble(scanner.nextLine());

        double totalWater = daysOfAdventure * countOfPlayers * waterPerDayForOnePerson;
        double totalFood = daysOfAdventure * countOfPlayers * foodPerDayForOnePerson;
        for (int i = 1; i <= daysOfAdventure; i++) {
            double energyLoos = Double.parseDouble(scanner.nextLine());
            groupEnergy -= energyLoos;
            if (groupEnergy <= 0) {
                System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.", totalFood, totalWater);
                return;
            }
            if (i % 2 == 0) {
                double amount = groupEnergy * 0.05;
                groupEnergy += amount;
                totalWater -= totalWater * 0.30;
            }
            if (i % 3 == 0) {
                groupEnergy += groupEnergy * 0.1;
                double amount = totalFood / countOfPlayers;
                totalFood -= amount;
            }

        }


        System.out.printf("You are ready for the quest. You will be left with - %.2f energy!", groupEnergy);


    }
}
