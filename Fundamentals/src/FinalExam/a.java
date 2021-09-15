package FinalExam;


import java.util.*;


public class a {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> heroesSpells = new TreeMap<>();

        while (true) {

            String input = scan.nextLine();

            if (input.equals("End")) {
                break;
            }

            String[] commands = input.split("\\s+");

            switch (commands[0]) {
                case "Enroll":
                    if (!heroesSpells.containsKey(commands[1])) {
                        heroesSpells.put(commands[1], new ArrayList<>());
                    } else {
                        System.out.println(commands[1] + " is already enrolled.");
                    }

                    break;
                case "Learn":
                    if (heroesSpells.containsKey(commands[1])) {
                        if (!heroesSpells.get(commands[1]).contains(commands[2])) {
                            heroesSpells.get(commands[1]).add(commands[2]);
                        } else {
                            System.out.println(commands[1] + " has already learnt " + commands[2] + ".");
                        }
                    } else {
                        System.out.println(commands[1] + " doesn't exist.");
                    }
                    break;
                case "Unlearn":
                    if (heroesSpells.containsKey(commands[1])) {
                        if (heroesSpells.get(commands[1]).contains(commands[2])) {
                            heroesSpells.get(commands[1]).remove(commands[2]);
                        } else {
                            System.out.println(commands[1] + " doesn't know " + commands[2] + ".");
                        }
                    } else {
                        System.out.println(commands[1] + " doesn't exist.");
                    }
                    break;
            }

        }
        System.out.println("Heroes:");
        heroesSpells.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .sorted((s1, s2) -> Integer.compare(s2.getValue().size(), s1.getValue().size()))
                .forEach(e -> System.out.printf("== %s: %s%n", e.getKey(), String.join(", ", e.getValue())));
    }
}