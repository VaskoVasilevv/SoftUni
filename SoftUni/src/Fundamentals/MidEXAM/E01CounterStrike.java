package bg.softuni.fundamentals.MidEXAM;


import java.util.Scanner;


public class E01CounterStrike {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        int startingEnergy = Integer.parseInt(myScanner.nextLine());

        String input;
        int wonBattles = 0;
        boolean isWin = true;

        while (!"End of battle".equals(input = myScanner.nextLine())) {

            int distance = Integer.parseInt(input);

            if (distance <= startingEnergy && startingEnergy != 0) {
                startingEnergy -= distance;
                wonBattles++;

                if (wonBattles % 3 == 0) {
                    startingEnergy += wonBattles;
                }

            } else {
                isWin = false;
                break;
            }


        }

        if (isWin) {
            System.out.printf("Won battles: %d. Energy left: %d", wonBattles, startingEnergy);
        } else {
            System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", wonBattles, startingEnergy);
        }

    }
}
