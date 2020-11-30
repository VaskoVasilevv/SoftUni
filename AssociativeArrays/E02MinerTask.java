package bg.softuni.fundamentals.AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E02MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> resource = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("stop")){
                int quantity = Integer.parseInt(scanner.nextLine());
                if (resource.containsKey(input)){
                    resource.put(input,resource.get(input)+ quantity);
                }
                resource.putIfAbsent(input, quantity);

            input = scanner.nextLine();
        }
        resource.entrySet().stream().forEach(e -> System.out.println(e.getKey()+ " -> " + e.getValue()));
    }
}
