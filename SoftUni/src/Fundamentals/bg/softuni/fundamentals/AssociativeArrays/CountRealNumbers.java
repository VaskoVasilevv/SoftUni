package bg.softuni.fundamentals.AssociativeArrays;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double,Integer> numberOccurences = new TreeMap<>();

        String [] line = scanner.nextLine().split(" ");
        for (int i = 0; i < line.length; i++) {
             double number = Double.parseDouble(line[i]);

             Integer occurrence = numberOccurences.get(number);
             if (occurrence == null){
                 occurrence = 0;
             }
             numberOccurences.put(number,occurrence + 1);
        }
        for (Map.Entry<Double, Integer> entry : numberOccurences.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}
