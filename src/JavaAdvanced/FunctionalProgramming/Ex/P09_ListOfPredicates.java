package JavaAdvanced.FunctionalProgramming.Ex;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P09_ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        Set<Integer> numbersSet = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toCollection(HashSet::new));

        Predicate<Integer> isDivisible = num -> {
            for (Integer divisor : numbersSet) {
                if (num % divisor != 0) {
                    return false;
                }
            }
            return true;
        };
        IntStream.range(1,number+1).filter(e-> isDivisible.test(e)).forEach(e -> System.out.print(e + " "));
//        for (int i = 1; i <= number ; i++) {
//            if (isDivisible.test(i)){
//                System.out.print(i + " ");
//            }
//
//        }

    }
}
