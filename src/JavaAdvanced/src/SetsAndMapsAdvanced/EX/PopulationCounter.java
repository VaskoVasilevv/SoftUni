package SetsAndMapsAdvanced.EX;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Long>> populationMap = new LinkedHashMap<>();
        String line = "";

        while (!"report".equals(line = scanner.nextLine())) {
            String[] tokens = line.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Long.parseLong(tokens[2]);

            populationMap.putIfAbsent(country,new LinkedHashMap<>());
            populationMap.get(country).putIfAbsent(city,population);


        }
        populationMap.entrySet().stream().sorted((c1,c2)->{
            long p1 = c1.getValue().values().stream().mapToLong(l -> l).sum();
            long p2 = c2.getValue().values().stream().mapToLong(l -> l).sum();
            return Long.compare(p2,p1);
        }).forEach(c->{
            long totalPopulation = c.getValue().values().stream().mapToLong(e->e).sum();
            System.out.println(String.format("%s (total population: %d)",c.getKey(),totalPopulation));
            Map<String, Long> cityInfo = c.getValue();
            cityInfo.entrySet().stream().sorted((c1,c2)->Long.compare(c2.getValue(),c1.getValue()))
                    .forEach(s -> System.out.println(String.format("=>%s: %d",s.getKey(),s.getValue())));

        });
    }
}
