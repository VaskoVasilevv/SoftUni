package Fundamentals.MidEXAM;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pirateShip = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> warShip = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int maxHealth = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        while (!command.equals("Retire")) {
            String[] commandArgument = command.split(" ");
            String commandName = commandArgument[0];
            switch (commandName) {
                case "Fire":
                    int fireIndex = Integer.parseInt(commandArgument[1]);
                    int damage = Integer.parseInt(commandArgument[2]);
                    if (fireIndex < 0 || fireIndex >= warShip.size()) {
                        break;
                    } else {
                        int sectionHealth = warShip.get(fireIndex);
                        sectionHealth -= damage;
                        if (sectionHealth <= 0) {
                            System.out.println("You won the enemy ship has sunken.");
                            return;
                        } else {
                            warShip.set(fireIndex, sectionHealth);
                        }
                    }

                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(commandArgument[1]);
                    int endIndex = Integer.parseInt(commandArgument[1]);
                    int damageIndex = Integer.parseInt(commandArgument[1]);
                    if (startIndex < 0 || endIndex >= pirateShip.size()) {
                        break;
                    } else {
                        for (int i = startIndex; i <= endIndex; i++) {
                            int currentSection = pirateShip.get(i);
                            currentSection -= damageIndex;
                            if (currentSection <= 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                return;
                            } else {
                                pirateShip.set(i, currentSection);
                            }

                        }
                    }
                    break;
                case "Repair":
                    int repairIndex = Integer.parseInt(commandArgument[1]);
                    int repairHealth = Integer.parseInt(commandArgument[2]);
                    if (repairIndex < 0 || repairIndex >= pirateShip.size()) {
                        break;
                    } else {
                        int sectionToRep = pirateShip.get(repairIndex);
                        sectionToRep += repairHealth;
                        if (sectionToRep > maxHealth) {
                            sectionToRep = maxHealth;
                        }
                        pirateShip.set(repairIndex, sectionToRep);
                    }
                    break;
                case "Status":
                    int count = 0;
                    for (Integer integer : pirateShip) {
                        if (integer < 0.2 * maxHealth) {
                            count++;
                        }
                    }
                    System.out.println(count + " sections need repair.");
                    break;
            }
            command = scanner.nextLine();
        }
        int pirateShipStatus = 0;
        int warShipStatus = 0;

        for (Integer integer : warShip) {
            warShipStatus += integer;
        }for (Integer integer : pirateShip) {
            pirateShipStatus += integer;
        }
        System.out.println("Pirate ship status: " + pirateShipStatus);
        System.out.println("Warship status: " + warShipStatus);

    }
}
