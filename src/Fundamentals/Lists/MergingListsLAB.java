package Fundamentals.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergingListsLAB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> first = parseLineOfNumbers(scanner);
        List<Integer> second = parseLineOfNumbers(scanner);
        List<Integer> mergedList = new ArrayList<>();

        int idenxInFirst = 0;
        int idenxInsecond = 0;
        while (idenxInFirst < first.size() || idenxInsecond < second.size()) {
            if (idenxInFirst < first.size()) {
                mergedList.add(first.get(idenxInFirst));
            }
            if (idenxInsecond < second.size()) {
                mergedList.add(second.get(idenxInsecond));
            }

            idenxInFirst++;
            idenxInsecond++;

        }

        for (int number : mergedList) {
            System.out.print(number + " ");
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
