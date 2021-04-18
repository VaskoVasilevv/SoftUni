package JavaAdvanced.FunctionalProgramming.Ex;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class P03_CustomMinFunction {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);



        Function<int[], Integer> getMinElement = x -> Arrays.stream(x).min().getAsInt();

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Integer apply = getMinElement.apply(numbers);
        System.out.println(apply);
    }
}
