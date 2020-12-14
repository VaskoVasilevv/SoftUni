package bg.softuni.fundamentals.MidEXAM;

import java.util.*;
import java.util.stream.Collectors;

public class E02TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> chestContentList = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());


        String command = scanner.nextLine();
        while (!command.equals("Yohoho!")) {

            String[] commandsArray = command.split(" ");
            String currentCommand = commandsArray[0];
            switch (currentCommand) {
                case "Loot":
                    for (int i = 1; i < commandsArray.length; i++) {
                        if (!chestContentList.contains(commandsArray[i])) {
                            chestContentList.add(0, commandsArray[i]);
                        }
                    }
                    break;
                case "Drop":
                    int dropIndex = Integer.parseInt(commandsArray[1]);
                    if (dropIndex < 0 || dropIndex >=chestContentList.size()){
                        break;
                    }else {
                        chestContentList.add(chestContentList.remove(dropIndex));
                    }
                    break;
                case "Steal":
                    int stealAmount = Integer.parseInt(commandsArray[1]);
                    List<String> stolen = new ArrayList<>();
                    for (int i = 0; i < stealAmount; i++) {
                        int lastIndex= chestContentList.size()-1;
                        stolen.add(chestContentList.remove(lastIndex));

                    }
                    Collections.reverse(stolen);
                    System.out.println(String.join(", ",stolen));
                    break;
            }
            command = scanner.nextLine();
        }
        int totalSizeOfLoot = 0;
        for (String currentLoot : chestContentList) {
            totalSizeOfLoot += currentLoot.length();
        }
        if (totalSizeOfLoot == 0){
            System.out.println("Failed treasure hunt.");
        }else {
            double average = (double) totalSizeOfLoot / chestContentList.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.",average);
        }

    }
}
