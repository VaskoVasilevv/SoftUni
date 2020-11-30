package bg.softuni.fundamentals.Lists;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Шаблони {
    public static void main(String[] args) {





    }
//    Принтиране на числа без последния символ
//    for (int i = 0; i < numbers.size(); i++) {
//        System.out.print(numbers.get(i));
//        if (i < numbers.size() - 1) {
//            System.out.print("|");
//        }
//
//    }



    // Принтира само числа разделени по ШПАЦИА
    // System.out.println(numbers.toString().replaceAll("[\\[\\],]",""));


    //  List<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split("\\s+"))
    //                .map(Integer::parseInt).collect(Collectors.toList());


    //String output = joinElementByDelimiter(numbers," ");
    //        System.out.println(output);
    public static String joinElementByDelimiter (List<Double> items , String delimiter){
        String output = "";

        for (Double item : items) {
            output += (new DecimalFormat("0.#").format(item)+ delimiter);
        }
        return output;

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

    // List<Double> numbers = parseLineOfNumbersToDuble(scanner);
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
}
