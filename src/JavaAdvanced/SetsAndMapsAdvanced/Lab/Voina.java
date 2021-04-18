package JavaAdvanced.SetsAndMapsAdvanced.Lab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<Integer> firstDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        LinkedHashSet<Integer> secondDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;

        while (rounds-- > 0 && !firstDeck.isEmpty() && !secondDeck.isEmpty()) {
            int first = 0;
            for (Integer integer : firstDeck) {
                first = integer;
                break;
            }
            int second = secondDeck.iterator().next();

            firstDeck.remove(first);
            secondDeck.remove(second);
            if (first > second) {
                firstDeck.add(first);
                firstDeck.add(second);
            }else {
                secondDeck.add(first);
                secondDeck.add(second);
            }
        }
        if (firstDeck.size() == secondDeck.size()){
            System.out.println("Draw!");
        }else if (secondDeck.size() < firstDeck.size()){
            System.out.println("First player win!");
        }else {
            System.out.println("Second player win!");
        }
    }
}
