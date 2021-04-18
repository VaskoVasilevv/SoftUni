package IteratorsAndComperators.Ex.Froggy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Lake lake = new Lake(Arrays.stream(scanner.nextLine().split(", "))
        .mapToInt(Integer::parseInt).toArray());
        scanner.nextLine();
        StringBuilder builder = new StringBuilder();
        for (Integer integer : lake) {
            builder.append(integer).append(", ");
        }
        String result = builder.toString();
        System.out.println(result.substring(0,result.lastIndexOf(",")));
    }
}
