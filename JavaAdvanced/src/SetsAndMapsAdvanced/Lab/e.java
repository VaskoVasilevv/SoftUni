package SetsAndMapsAdvanced.Lab;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class e {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, double[]> person = new TreeMap<>();

        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= count; i++) {
            String name = scanner.nextLine();
            double[] grade = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
            person.putIfAbsent(name, grade);

        }
        for (Map.Entry<String, double[]> stringDoubleEntry : person.entrySet()) {
            System.out.printf("%s is graduated with ", stringDoubleEntry.getKey());
            System.out.println(getAverage(stringDoubleEntry.getValue()));
        }
    }

    private static double getAverage(double[] value) {
        double sum = 0;
        for (double v : value) {
            sum += v;
        }
        return sum / value.length;
    }
}
