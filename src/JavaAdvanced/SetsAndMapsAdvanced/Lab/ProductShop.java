package JavaAdvanced.SetsAndMapsAdvanced.Lab;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<Double>>> map = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Revision")) {
            String[] tokens = input.split(", ");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            map.putIfAbsent(shop, new LinkedHashMap<>());
            map.get(shop).putIfAbsent(product, new ArrayList<>());
            map.get(shop).get(product).add(price);

            input = scanner.nextLine();
        }
        map.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + "->");
            entry.getValue()
                    .forEach((k, v) -> {
                        System.out.print("Product: "+k+", Price: ");
                        v.forEach(e-> System.out.printf("%.1f%n",e));
                    });
        });
    }
}
