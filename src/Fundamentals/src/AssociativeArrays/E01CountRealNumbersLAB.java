package AssociativeArrays;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class E01CountRealNumbersLAB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] pats = scanner.nextLine().split(" ");

        Map<Double, Integer> occurrences = new TreeMap<>();
        for (String pat : pats) {
            double currentNumber = Double.parseDouble(pat);

            if (occurrences.containsKey(currentNumber)){
                Integer currntCount =  occurrences.get(currentNumber);

                occurrences.put(currentNumber, currntCount +1);

            }else {
                occurrences.put(currentNumber,1);
            }
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.#######");
        for (Map.Entry<Double, Integer> entry : occurrences.entrySet()) {
            System.out.printf("%s -> %d%n",decimalFormat.format(entry.getKey()),entry.getValue());
        }


    }
}
