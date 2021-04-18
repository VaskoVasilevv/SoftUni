package JavaAdvanced.Exam.P22Feb2020;

import java.util.*;
import java.util.stream.Collectors;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Queue
        ArrayDeque<Integer> firstLootbox = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        //Stack
        ArrayDeque<Integer> secondLootbox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(secondLootbox::push);

        int items = 0;
        while (!firstLootbox.isEmpty() && !secondLootbox.isEmpty()){
            int firstElement = firstLootbox.peek();
            int secondElement = secondLootbox.pop();
            int sum = firstElement+secondElement;

            if (sum % 2 == 0){
                firstLootbox.poll();
                items += sum;
            }else {
                firstLootbox.offerLast(secondElement);
            }
        }
        if (firstLootbox.isEmpty()){
            System.out.println("First lootbox is empty");
            if (items >= 100){
                System.out.println("Your loot was epic! Value: " + items);
            }else {
                System.out.println("Your loot was poor... Value: " + items);
            }
        }
        if (secondLootbox.isEmpty()){
            System.out.println("Second lootbox is empty");
            if (items >= 100){
                System.out.println("Your loot was epic! Value: " + items);
            }else {
                System.out.println("Your loot was poor... Value: " + items);
            }
        }
    }
}
