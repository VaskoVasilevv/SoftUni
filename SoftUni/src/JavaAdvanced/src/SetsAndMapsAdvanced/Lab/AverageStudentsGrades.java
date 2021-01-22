package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> info = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            info.putIfAbsent(name,new ArrayList<>());
            info.get(name).add(grade);
        }
        info.entrySet().forEach(entry->{
            System.out.printf("%s -> ",entry.getKey());
            entry.getValue().forEach(e-> System.out.printf("%.2f ",e));
            System.out.printf("(avg: %.2f)%n",getAverage(entry.getValue()));
        });
    }
    private static double getAverage(List<Double> value) {
        double sum = 0;
        for (double v : value) {
            sum += v;
        }
        return sum / value.size();
    }
}
