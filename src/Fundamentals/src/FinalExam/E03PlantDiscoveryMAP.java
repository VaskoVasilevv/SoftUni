package FinalExam;

import java.util.*;

public class E03PlantDiscoveryMAP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> plantRarityByName = new HashMap<>();
        Map<String, List<Integer>> plantListOFRatingsByName = new HashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] nameAndRarity = scanner.nextLine().split("<->");
            plantRarityByName.put(nameAndRarity[0], Integer.parseInt(nameAndRarity[1]));
            plantListOFRatingsByName.put(nameAndRarity[0], new ArrayList<>());
        }

        String command = scanner.nextLine();
        while (!command.equals("Exhibition")) {

            String[] commandAndParameters = command.split(": ");

            switch (commandAndParameters[0]) {
                case "Rate":
                    String[] rateParameters = commandAndParameters[1].split(" - ");
                    String ratePlantName = rateParameters[0];
                    int rating = Integer.parseInt(rateParameters[1]);

                    List<Integer> ratings = plantListOFRatingsByName.get(ratePlantName);
                    if (ratings != null) {
                        ratings.add(rating);
                    } else {
                        System.out.println("error");
                    }

                    break;
                case "Update":
                    String[] updateParameters = commandAndParameters[1].split(" - ");
                    String updatePlantName = updateParameters[0];
                    int rarity = Integer.parseInt(updateParameters[1]);


                    if (plantRarityByName.containsKey(updatePlantName)) {
                        plantRarityByName.put(updatePlantName, rarity);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Reset":
                    String resetPlantName = commandAndParameters[1];

                    List<Integer> resetRatings = plantListOFRatingsByName.get(resetPlantName);
                    if (resetRatings != null) {
                        resetRatings.clear();
                    } else {
                        System.out.println("error");
                    }
                    break;
                default:
                    System.out.println("error");
                    break;
            }

            command = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");

        plantRarityByName.entrySet()
                .stream()
                .sorted((a, b) -> {
                    int aRarity = a.getValue();
                    int bRarity = b.getValue();

                    if (aRarity != bRarity) {
                        return Integer.compare(bRarity, aRarity);
                    } else {
                        List<Integer> aRatingsList = plantListOFRatingsByName.get(a.getKey());
                        List<Integer> bRatingsList = plantListOFRatingsByName.get(b.getKey());
                        double aAverageRating = calculateAverage(aRatingsList);
                        double bAverageRating = calculateAverage(bRatingsList);

                        return Double.compare(bAverageRating, aAverageRating);
                    }

                })
                .map(entry -> "- " + entry.getKey() + "; Rarity: " + entry.getValue() + "; Rating: " + String.format("%.2f", calculateAverage(plantListOFRatingsByName.get(entry.getKey()))))
                .forEach(s -> System.out.println(s));

    }

    static double calculateAverage(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        double sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum / numbers.size();

    }

}
