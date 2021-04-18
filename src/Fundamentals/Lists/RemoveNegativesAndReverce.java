package Fundamentals.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RemoveNegativesAndReverce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = parseLineOfNumbers(scanner);

        List<Integer>nonNEgative = new ArrayList<>();
        for (Integer number : numbers) {
            if (number >= 0){
                nonNEgative.add(number);
            }
        }
        if (nonNEgative.isEmpty()){
            System.out.println("empty");
        }
        Collections.reverse(nonNEgative);
        for (Integer integer : nonNEgative) {
            System.out.print(integer + " ");
        }


    }
    private static void removeNegativeFromLIst(List<Integer> numbers) {
        int i = 0;
        while (i < numbers.size()) {
            if (numbers.get(i) < 0) {
                numbers.remove(i);
            } else {
                i++;
            }
        }
    }
    private static List<Integer> parseLineOfNumbers(Scanner scanner) {
        String line = scanner.nextLine();
        String[] numbersAsStrings = line.split(" ");

        List<Integer> numbers = new ArrayList<>();

        for (String s : numbersAsStrings) {
            int number = Integer.parseInt(s);
            numbers.add(number);
        }
        return numbers;
    }
}
