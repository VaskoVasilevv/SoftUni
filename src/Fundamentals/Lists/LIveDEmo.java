package Fundamentals.Lists;

import java.text.DecimalFormat;
import java.util.*;

public class LIveDEmo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = parseLineOfNumbers(scanner);
        String input = scanner.nextLine();


        while (!input.equals("end")) {
            String[] comand = input.split(" ");

            switch (comand[0]) {
                case "Add":
                    int nuberToAdd = Integer.parseInt(comand[1]);
                    numbers.add(nuberToAdd);
                    break;
                case "Remove":
                    int numberToRemove = Integer.parseInt(comand[1]);
                    numbers.remove((Integer)  numberToRemove);
                    break;
                case "RemoveAt":
                    int indexToRemove = Integer.parseInt(comand[1]);
                    numbers.remove(indexToRemove);
                    break;
                case "Insert":
                    int numberToInsert = Integer.parseInt(comand[1]);
                    int indexToInsert = Integer.parseInt(comand[2]);
                    numbers.add(indexToInsert,numberToInsert);
                    break;
            }


            input = scanner.nextLine();
        }
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }


    }

    static String joinElementByDelimiter(List<Double> items, String delimiter) {
        String output = "";

        for (Double item : items) {
            output += (new DecimalFormat("0.#").format(item) + delimiter);
        }
        return output;

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

    public static List<Double> parseLineOfNumbersToDuble(Scanner scanner) {
        String line = scanner.nextLine();
        String[] numbersAsStrings = line.split(" ");

        List<Double> numbers = new ArrayList<>();

        for (String s : numbersAsStrings) {
            double number = Double.parseDouble(s);
            numbers.add(number);
        }
        return numbers;
    }
}
