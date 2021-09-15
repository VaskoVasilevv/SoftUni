package Exam.P17Dec2019;

import java.util.*;
import java.util.stream.Collectors;

public class P01_SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Stack
        ArrayDeque<Integer> materials = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(materials::push);

        //Queue
        ArrayDeque<Integer> magicLevelValue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        Map<String, Integer> presents = new TreeMap<>();
        presents.put("Doll", 0);
        presents.put("Wooden train", 0);
        presents.put("Teddy bear", 0);
        presents.put("Bicycle", 0);

        while (!materials.isEmpty() && !magicLevelValue.isEmpty()) {

            int first = materials.peek();
            int second = magicLevelValue.peek();

            if (first != 0 && second != 0) {
                int sum = first * second;

                if (sum < 0) {
                    materials.pop();
                    magicLevelValue.poll();
                    sum = first + second;
                    materials.push(sum);
                } else {
                    materials.pop();
                    magicLevelValue.poll();
                    switch (sum) {
                        case 150:
                            presents.put("Doll", presents.get("Doll") + 1);
                            break;
                        case 250:
                            presents.put("Wooden train", presents.get("Wooden train") + 1);

                            break;
                        case 300:
                            presents.put("Teddy bear", presents.get("Teddy bear") + 1);

                            break;
                        case 400:
                            presents.put("Bicycle", presents.get("Bicycle") + 1);

                            break;
                        default:
                            materials.push(first + 15);
                            break;
                    }
                }
            }else {
                if (first == 0){
                    materials.pop();
                }
                if (second == 0){
                    magicLevelValue.poll();
                }
            }
        }
        if (((presents.get("Teddy bear") > 0 && presents.get("Bicycle") > 0))
                || (presents.get("Wooden train") > 0 && presents.get("Doll") > 0)) {

            System.out.println("The presents are crafted! Merry Christmas!");

        } else {
            System.out.println("No presents this Christmas!");
        }
        if (!materials.isEmpty()) {
            System.out.printf("Materials left: %s%n", materials.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        }
        if (!magicLevelValue.isEmpty()) {
            System.out.printf("Magic left: %s%n", magicLevelValue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        presents.entrySet().stream().filter(p -> p.getValue() > 0).forEach(p -> System.out.printf("%s: %d%n", p.getKey(), p.getValue()));
    }
}
