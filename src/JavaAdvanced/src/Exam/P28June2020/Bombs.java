package Exam.P28June2020;

import java.util.*;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Queue
        ArrayDeque<Integer> bombEffects = Arrays.stream(scanner.nextLine()
                .split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        //Stack
        ArrayDeque<Integer> bombCasing = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(bombCasing::push);


        Map<String, Integer> bombType = new TreeMap<>();
        bombType.put("Datura Bombs", 0);
        bombType.put("Cherry Bombs", 0);
        bombType.put("Smoke Decoy Bombs", 0);
        int coutC = 0;
        int coutD = 0;
        int coutS = 0;

        while (!bombEffects.isEmpty() && !bombCasing.isEmpty() && (coutC < 3 || coutS < 3 || coutD < 3)) {
            int currentBombEffects = bombEffects.poll();
            int currentBombCasing = bombCasing.pop();

            int sum = currentBombEffects + currentBombCasing;
            if (sum == 40) {
                bombType.put("Datura Bombs",bombType.get("Datura Bombs") +1);
                coutD++;
            } else if (sum == 60) {
                coutC++;
                bombType.put("Cherry Bombs",bombType.get("Cherry Bombs") +1);

            } else if (sum == 120) {
                coutS++;
                bombType.put("Smoke Decoy Bombs",bombType.get("Smoke Decoy Bombs") +1);
            } else {
                currentBombCasing -= 5;
                bombCasing.push(currentBombCasing);
                bombEffects.offerFirst(currentBombEffects);
            }
        }
        if (coutC< 3 || coutD<3 ||coutS<3) {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        } else {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }
        System.out.print("Bomb Effects: ");
        if (bombEffects.isEmpty()) {
            System.out.printf("empty%n");
        } else {
            System.out.print(String.join(", ", bombEffects.toString().replaceAll("[\\[\\]]", "")));
            System.out.println();
        }
        System.out.print("Bomb Casings: ");
        if (bombCasing.isEmpty()) {
            System.out.printf("empty%n");
        } else {
            System.out.printf("Bomb Casings: %s%n", String.join(", ", bombCasing.toString().replaceAll("[\\[\\]]", "")));            System.out.println();
        }
        bombType.entrySet().stream().forEach(e -> System.out.printf("%s: %d%n",e.getKey(),e.getValue()));
    }


}
