package Fundamentals.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperationsEX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());


        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            switch (command) {
                case "Add":
                    numbers.add(Integer.parseInt(tokens[1]));
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < numbers.size()) {
                        numbers.add(index, Integer.parseInt(tokens[1]));
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < numbers.size()) {
                        numbers.remove(index);
                    } else {
                        System.out.println("Invalid index");

                    }
                    break;
                case "Shift":
                    String direction = tokens[1];
                    int count = Integer.parseInt(tokens[2]);
                    shift(numbers, direction, count);
                    break;
            }
            input = scanner.nextLine();
        }
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }

    }

    private static void shift(List<Integer> numbers, String direction, int count) {
        switch (direction) {
            case "left":
                for (int i = 0; i < count; i++) {
                    int first = numbers.get(0);
                    numbers.remove(0);
                    numbers.add(first);
                }
                break;
            case "right":
                for (int i = 0; i < count; i++) {
                    int last = numbers.get(numbers.size() - 1);
                    numbers.remove(numbers.size() - 1);
                    numbers.add(0, last);

                }
                break;
        }
    }
}
