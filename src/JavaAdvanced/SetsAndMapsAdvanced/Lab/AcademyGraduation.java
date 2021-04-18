package JavaAdvanced.SetsAndMapsAdvanced.Lab;


import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        Map<String, double[]> studentsWithGrades = new TreeMap<>();

        while (n-- > 0) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine()
                    .split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            studentsWithGrades.put(name, grades);

        }
        studentsWithGrades.forEach((k, v) -> System.out.println(k+" is graduated with "+ getAverage(v)));

    }

    private static double getAverage(double[] value) {
        double sum = 0;
        for (double v : value) {
            sum += v;
        }
        return sum / value.length;
    }
}
