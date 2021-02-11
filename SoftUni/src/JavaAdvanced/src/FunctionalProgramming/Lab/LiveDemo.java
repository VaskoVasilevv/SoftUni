package FunctionalProgramming.Lab;


import java.util.Arrays;

import java.util.List;
import java.util.Scanner;


import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LiveDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


    }

    public static boolean isPrime(int number) {
        boolean isPrime =
                IntStream.range(2, number).noneMatch(n -> isDivisibleBy(number, n));
        return isPrime && number > 1;
    }

    public static boolean isDivisibleBy(int number, int divisor) {
        return number % divisor == 0;
    }

    public static boolean isGreather(int first, int second) {
        return first > second;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static String formatArray(int[] arr) {
        return Arrays.stream(arr).mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
