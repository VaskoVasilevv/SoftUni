package FunctionalProgramming.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;

public class P02_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Function<String, Integer> getCount = str -> {
            Arrays.stream(str.split(", "))
                    .mapToInt(Integer::parseInt)
                    .count();


            return null;
        };
        Function<String, Integer> getSum = str -> {
            return Arrays.stream(str.split(", "))
                    .mapToInt(Integer::parseInt)
                    .sum();

        };


        System.out.println("Count = " + getCount.apply(line));
        System.out.println("Sum =" + getSum.apply(line));


    }
}
