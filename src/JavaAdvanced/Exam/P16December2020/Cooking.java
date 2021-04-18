package JavaAdvanced.Exam.P16December2020;

import java.util.*;
import java.util.stream.Collectors;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //Queue
        ArrayDeque<Integer> liquids = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));
        //Stack
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredients::push);

        Map<Integer, String> cookingTable = new HashMap<>();
        cookingTable.put(25,"Bread");
        cookingTable.put(50,"Cake");
        cookingTable.put(75,"Pastry");
        cookingTable.put(100,"Fruit Pie");

        Map<String, Integer> productCoocked = new TreeMap<>();

        cookingTable.values().stream()
                .forEach(p -> productCoocked.put(p,0));

        while (liquids.isEmpty() == false && ingredients.isEmpty() == false) {
            int currentLiquid = liquids.poll();
            int currentIngreadint = ingredients.pop();
            int sum = currentIngreadint + currentLiquid;
            if (ableToCoocProduct(sum)) {
                String product = cookingTable.get(sum);

                productCoocked.put(product,productCoocked.get(product)+1);
            } else {
                ingredients.push(currentIngreadint + 3);
            }
        }
        if (hasCoockedMeeal(productCoocked)){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }

        System.out.println("Liquids left: " + getElemet(liquids));
        System.out.println("Ingredients left: " + getElemet(ingredients));
        productCoocked.forEach((k,v) ->{
            System.out.println(k + ": " + v);
        });

    }

    private static String getElemet(ArrayDeque<Integer> liquids) {
        return liquids.isEmpty()
                ?"none"
                : liquids.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));


    }

    private static boolean hasCoockedMeeal(Map<String, Integer> productCoocked) {
        for (Integer count : productCoocked.values()) {
            if (count == 0){
                return false;
            }
        }
        return true;
    }

    private static boolean ableToCoocProduct(int sum) {
        return sum == 25 || sum == 50 || sum == 75 || sum ==100;
    }

}
