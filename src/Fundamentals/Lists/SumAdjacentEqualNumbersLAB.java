package Fundamentals.Lists;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumAdjacentEqualNumbersLAB {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = parseLineOfNumbersToDuble(scanner);

        int i = 0;
        while (i < numbers.size() - 1) {
            double courrent = numbers.get(i);
            double next = numbers.get(i + 1);
            if (courrent == next) {
                numbers.remove(i);
                numbers.set(i,courrent + next);
                i = 0;
            } else {
                i++;
            }
        }

        String output = joinElementByDelimiter(numbers," ");
        System.out.println(output);



    }
    static String joinElementByDelimiter (List<Double> items , String delimiter){
        String output = "";

        for (Double item : items) {
            output += (new DecimalFormat("0.#").format(item)+ delimiter);
        }
        return output;

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
