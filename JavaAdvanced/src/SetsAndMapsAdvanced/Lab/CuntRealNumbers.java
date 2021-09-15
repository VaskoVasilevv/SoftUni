package SetsAndMapsAdvanced.Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CuntRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        Map<Double,Integer> numbersWithCount = new LinkedHashMap<>();

        for (double number : numbers) {
            numbersWithCount.putIfAbsent(number,0);
            numbersWithCount.put(number,numbersWithCount.get(number)+1);
        }
        numbersWithCount.forEach((k,v)-> {
            System.out.printf("%.1f -> %d%n",k,v);
        });

    }
}
