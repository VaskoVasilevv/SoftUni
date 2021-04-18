package JavaAdvanced.FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MyStrings {
    public static String formatArray(int[] arr) {
        return Arrays.stream(arr).mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }

    public static Predicate<String> startsWithUppercase = str -> str != null && str.isEmpty() && Character.isUpperCase(str.charAt(0));

}
