package Fundamentals.MidEXAM;

import java.lang.reflect.Array;
import java.util.*;

public class NumbersEXAM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        double average = (double) sum / numbers.length;
        int cpunt = 0;
        List<Integer> aboveNumbers = new ArrayList<>();
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] > average) {
                cpunt++;
                if (cpunt <= 5) {
                    aboveNumbers.add(numbers[i]);
                }
            }
        }
        if (aboveNumbers.isEmpty()) {
            System.out.println("No");
        } else {
            Collections.sort(aboveNumbers);
            Collections.reverse(aboveNumbers);

            for (Integer aboveNumber : aboveNumbers) {
                System.out.print(aboveNumber + " ");
            }
        }
    }
}
