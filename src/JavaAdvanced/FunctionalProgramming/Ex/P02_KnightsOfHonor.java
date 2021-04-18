package JavaAdvanced.FunctionalProgramming.Ex;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class P02_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        Consumer<String> consumer = str -> System.out.println("Sir "+ str);
        Arrays.stream(input).forEach(consumer);
    }
}
