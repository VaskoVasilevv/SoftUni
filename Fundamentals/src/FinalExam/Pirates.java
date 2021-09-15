package FinalExam;

import java.util.*;

public class Pirates {
    static class Pirate {
        String town;
        int people;
        int gold;

        public Pirate(String name, int people, int gold) {
            this.town = name;
            this.people = people;
            this.gold = gold;
        }

        public int getPeople() {
            return people;
        }

        public int getGold() {
            return gold;
        }

        public void addPeople(int people) {
            this.people += people;
        }

        public void reducePeople(int people) {
            this.people -= people;
        }

        public void addGold(int gold) {
            this.gold += gold;
        }

        public void reduceGoldGold(int gold) {
            this.gold -= gold;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Pirate> piratesMap = new TreeMap<>();
        while (!input.equals("Sail")) {
            String[] tokens = input.split("\\|\\|");
            String name = tokens[0];
            int people = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);
            if (gold < 0) {
                System.out.println("Gold added cannot be a negative number!");
                break;
            }
            Pirate p = new Pirate(name, people, gold);
            if (!piratesMap.containsKey(name)) {
                piratesMap.put(name, p);
            } else {
                piratesMap.get(name).addPeople(people);
                piratesMap.get(name).addGold(gold);
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] commands = input.split("=>");
            String town = commands[1];
            if ("Plunder".equals(commands[0])) {
                int population = Integer.parseInt(commands[2]);
                int gold = Integer.parseInt(commands[3]);
                piratesMap.get(town).reducePeople(population);
                piratesMap.get(town).reduceGoldGold(gold);
                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, population);
                if (piratesMap.get(town).getGold() <= 0 || piratesMap.get(town).getPeople() <= 0) {
                    piratesMap.remove(town);
                    System.out.printf("%s has been wiped off the map!%n", town);
                }
            } else {
                int gold = Integer.parseInt(commands[2]);
                if (gold < 0) {
                    System.out.println("Gold added cannot be a negative number!");
                } else {
                    piratesMap.get(town).addGold(gold);
                    System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, town, piratesMap.get(town).getGold());
                }
            }


            input = scanner.nextLine();
        }
        System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", piratesMap.size());
        piratesMap.entrySet().stream()
                .sorted((a, b) -> b.getValue().getGold() - a.getValue().getGold())
                .forEach(e -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", e.getKey(), e.getValue().getPeople(), e.getValue().getGold()));

    }
}
