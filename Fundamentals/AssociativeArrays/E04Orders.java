package bg.softuni.fundamentals.AssociativeArrays;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E04Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> products = new LinkedHashMap<>();
        Map<String, Integer> rememberProducts = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("buy")) {
            String[] tokens = input.split(" ");
            String name = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            int quantity = Integer.parseInt(tokens[2]);

            if (!products.containsKey(name)) {
                products.put(name, quantity * price);
                rememberProducts.put(name, quantity);
            } else {
                rememberProducts.put(name, rememberProducts.get(name) + quantity);
                products.put(name, rememberProducts.get(name) * price);
            }
            input = scanner.nextLine();
        }
        products.forEach((k, v) -> System.out.printf("%s -> %.2f%n", k, v));
    }
}
