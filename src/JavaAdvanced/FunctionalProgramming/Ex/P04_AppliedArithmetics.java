package JavaAdvanced.FunctionalProgramming.Ex;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class P04_AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[],int[]> addOne = arr -> Arrays.stream(arr).map(e -> e +1).toArray();
        Function<int[],int[]> multiplyByTwo = arr -> Arrays.stream(arr).map(e -> e * 2).toArray();
        Function<int[],int[]> subtract = arr -> Arrays.stream(arr).map(e -> e - 1).toArray();

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    numbers = addOne.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplyByTwo.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "print":
                    Arrays.stream(numbers).forEach(e -> System.out.print(e + " "));
                    System.out.println();
                    break;

            }

            command = scanner.nextLine();
        }
    }
}
