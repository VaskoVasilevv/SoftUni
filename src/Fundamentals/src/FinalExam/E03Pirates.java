package FinalExam;

import java.util.*;

public class E03Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, int[]> towns = new TreeMap<>();
        while (!"Sail".equals(input)) {
            String[] town = input.split("\\|\\|");
            towns.putIfAbsent(town[0], new int[2]);
            towns.get(town[0])[0] += Integer.parseInt(town[1].trim());
            towns.get(town[0])[1] += Integer.parseInt(town[2].trim());
            input = scanner.nextLine();
        }
        while (!"End".equals(input)) {
            String[] command = input.split("=>");
            switch (command[0]) {
                case "Plunder":
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", command[1], Integer.parseInt(command[3].trim()), Integer.parseInt(command[2].trim()));
                    towns.get(command[1])[0] -= Integer.parseInt(command[2].trim());
                    towns.get(command[1])[1] -= Integer.parseInt(command[3].trim());
                    if (towns.get(command[1])[0] == 0 || towns.get(command[1])[1] == 0) {
                        towns.remove(command[1]);
                        System.out.printf("%s has been wiped off the map!%n", command[1]);
                    } break;
                case "Prosper":
                    if (Integer.parseInt(command[2].trim()) < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        towns.get(command[1])[1] += Integer.parseInt(command[2].trim());
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", Integer.parseInt(command[2].trim()), command[1], towns.get(command[1])[1]);
                    } break;
            }
            input = scanner.nextLine();
        }
        if (towns.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", towns.size());
            towns.entrySet().stream().sorted((one, two) -> Integer.compare(two.getValue()[1], one.getValue()[1]))
                    .forEach(e -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", e.getKey(), e.getValue()[0], e.getValue()[1]));
        }
    }
}
