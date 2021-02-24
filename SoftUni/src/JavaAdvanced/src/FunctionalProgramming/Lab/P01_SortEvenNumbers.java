package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 == 0)
                .toArray();

        System.out.println(formatArray(numbers));
        Arrays.sort(numbers);
        System.out.println(formatArray(numbers));

    }
    public static boolean isEven (int number){
        return number % 2 == 0;
    }
    public static String formatArray (int[] arr){
        return Arrays.stream(arr).mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
