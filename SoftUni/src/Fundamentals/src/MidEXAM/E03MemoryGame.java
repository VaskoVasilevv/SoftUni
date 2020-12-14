package bg.softuni.fundamentals.MidEXAM;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E03MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = scanner.nextLine();
        int count = 0;
        int moves = 0;
        while (!input.equals("end")) {
            moves--;
            count++;
            String[] tokens = input.split(" ");
            int index = Integer.parseInt(tokens[0]);
            String value = tokens[1];

            if (index >= 0 && index < list.size() && Integer.parseInt(value) >= 0 && Integer.parseInt(value) < list.size() && index != Integer.parseInt(value)) {
                if (list.get(index).equals(list.get(Integer.parseInt(value)))) {
                    if (index > Integer.parseInt(value)) {
                        System.out.printf("Congrats! You have found matching elements - %s!%n", list.get(index));
                        list.remove(index);
                        list.remove(Integer.parseInt(value));
                    } else {
                        System.out.printf("Congrats! You have found matching elements - %s!%n", list.get(Integer.parseInt(value)));
                        list.remove(Integer.parseInt(value));
                        list.remove(index);
                    }
                    if (list.size() == 0) {
                        System.out.printf("You have won in %d turns!%n", Math.abs(count));
                        return;
                    }
                } else  {
                    System.out.println("Try again!");
                }
            } else {
                list.add(list.size() / 2, moves + "a");
                list.add(list.size() / 2, moves + "a");
                System.out.println("Invalid input! Adding additional elements to the board");
            }

            input = scanner.nextLine();
        }

        System.out.println("Sorry you lose :(");
        for (String s : list) {
            System.out.print(s + " ");
        }

    }


}


