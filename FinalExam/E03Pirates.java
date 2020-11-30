package bg.softuni.fundamentals.FinalExam;

import java.awt.geom.GeneralPath;
import java.util.*;

public class E03Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<Integer>> map = new HashMap<>();

        while (!input.equals("Sail")) {
            String[] tokens = input.split("\\|\\|");
            String cities = tokens[0];
            int population = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);

            if (!map.containsKey(cities)) {
                map.put(cities, new ArrayList<>(Arrays.asList(population,gold)));

            }else {

            }


            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!"End".equals(input)) {


            input = scanner.nextLine();
        }
    }
}
