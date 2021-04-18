package Fundamentals.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGameEX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());


        while (!(firstPlayer.isEmpty() || secondPlayer.isEmpty())) {
            int first = firstPlayer.get(0);
            int second = secondPlayer.get(0);


            if (first > second) {
                firstPlayer.remove(0);
                secondPlayer.remove(0);
                firstPlayer.add(first);
                firstPlayer.add(second);

            } else if (second > first) {
                secondPlayer.remove(0);
                firstPlayer.remove(0);
                secondPlayer.add(second);
                secondPlayer.add(first);
            }else {
                firstPlayer.remove(0);
                secondPlayer.remove(0);
            }

        }
        int sum = 0;
        if (!firstPlayer.isEmpty()) {
            for (Integer integer : firstPlayer) {
                sum += integer;
            }

        }
        int sum2 = 0;
        if (!secondPlayer.isEmpty()){
            if (!secondPlayer.isEmpty()){
                for (Integer integer : secondPlayer) {
                    sum2 += integer;
                }

            }

        }
        if (sum > sum2) {
            System.out.printf("First player wins! Sum: %d", sum);
        }else {
            System.out.printf("Second player wins! Sum: %d",sum2);
        }
    }
}
