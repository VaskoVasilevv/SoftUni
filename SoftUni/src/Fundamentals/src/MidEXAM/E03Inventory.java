package bg.softuni.fundamentals.MidEXAM;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E03Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> itemsList = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Craft!")) {
            String[] data = input.split(" - ");
            String command = data[0];
            String item = data[1];

            switch (command) {
                case "Collect":
                    if (itemsList.contains(item)) {
                        break;
                    } else {
                        itemsList.add(item);
                    }
                    break;
                case "Drop":
                    if (itemsList.contains(item)) {
                        itemsList.remove(item);
                        break;
                    }
                    break;
                case "Combine Items":
                    String [] combineItems = item.split(":");
                    String oldItem = combineItems[0];
                    if (itemsList.contains(oldItem)){
                        itemsList.add(((itemsList.indexOf(oldItem))+1),combineItems[1]);
                    }
                    break;
                case "Renew":
                    if (itemsList.contains(item)){
                        itemsList.add(item);
                        itemsList.remove(item);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(String.join(", ", itemsList));
    }
}
