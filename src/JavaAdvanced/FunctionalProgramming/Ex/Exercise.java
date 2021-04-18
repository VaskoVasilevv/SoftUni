package JavaAdvanced.FunctionalProgramming.Ex;


import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Exercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        Set<Integer> set = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toSet());
        Predicate<Integer> isDivisible = num -> {
            for (Integer divisior : set) {
                if (num % divisior != 0){
                    return false;
                }

            }
            return true;

        };
        IntStream.range(1,n+1).filter(e-> isDivisible.test(e)).forEach(e -> System.out.print(e + " "));

    }
}
