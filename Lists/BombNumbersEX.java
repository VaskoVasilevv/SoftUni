package bg.softuni.fundamentals.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbersEX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> bombInfo = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int bombNum = bombInfo.get(0);
        int power = bombInfo.get(1);

        while (list.contains(bombNum)) {
            int bombPossition = list.indexOf(bombNum);

            int leftBomb = Math.max(0, bombPossition - power);
            int rightBomb = Math.min(list.size() - 1, bombPossition + power);

            for (int i = rightBomb; i >= leftBomb; i--) {
                list.remove(i);

            }


        }
        int sum = 0;
        for (Integer n : list) {
            sum+=n;
        }
        System.out.println(sum);

    }
}
