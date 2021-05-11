package MidEXAM;

import java.util.*;

public class Loot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] itemsText = scanner.nextLine().split("\\|");
        List<String> items = new ArrayList<>(Arrays.asList(itemsText));

        String input = scanner.nextLine();
        while (!"Yohoho!".equals(input)) {
            String[] tokens = input.split("\\s+", 2);
            String command = tokens[0];

            switch (command) {
                case "Loot":
                    String[] loot = tokens[1].split(" ");
                    for (String s : loot) {
                        if (!items.contains(s)) {
                            items.add(0, s);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < items.size()) {
                        String remove = items.remove(index);
                        items.add(remove);
                    }
                    break;
                case "Steal":
                    int count = Integer.parseInt(tokens[1]);
                    List<String> stolen = new ArrayList<>();
                    while (stolen.size() < count && !items.isEmpty()) {
                        int lastIndex = items.size() - 1;
                        stolen.add(items.get(lastIndex));
                        items.remove(lastIndex);
                    }

                    Collections.reverse(stolen);
                    System.out.println(String.join(", ", stolen));

                    break;
                default:
                    throw new IllegalStateException("Unknown DesignPatterns.Ex.command");
            }
            input = scanner.nextLine();
        }

        int count = 0;
        double totalLength = 0;
        for (String item : items) {
            int length = item.length();
            totalLength += length;
            count++;
        }

        if (items.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            System.out.printf("Average treasure gain: %.2f pirate credits.%n", totalLength / count);
        }
    }
}