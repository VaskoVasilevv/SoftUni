package bg.softuni.fundamentals.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeListEX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            Integer num = Integer.valueOf(tokens[1]);
            String commmand = tokens[0];
            if (commmand.equals("Delete")) {
                for (int i = 0; i < numbers.size(); i++) {
                    numbers.remove((Integer) Integer.parseInt(tokens[1]));

                }
            } else if (commmand.equals("Insert")) {
                int position = Integer.parseInt(tokens[2]);
                if (position >= 0 && position < numbers.size()) {

                    numbers.add(Integer.parseInt(tokens[2]), num);
                }
            }
            input = scanner.nextLine();
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
