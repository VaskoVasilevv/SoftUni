package Exam.Demo23Oct2019;

import java.util.*;
import java.util.stream.Collectors;

public class MakeSalad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Queue
        ArrayDeque<String> vegetables = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));

        //Stack
        ArrayDeque<Integer> calories = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(calories::push);

        Map<String, Integer> salad = new HashMap<>();
        salad.put("tomato", 80);
        salad.put("carrot", 136);
        salad.put("lettuce", 109);
        salad.put("potato", 215);

        List<Integer> readySalad = new ArrayList<>();
        while (!vegetables.isEmpty() && !calories.isEmpty()) {
            int calorie = calories.pop();
            readySalad.add(calorie);
            String vegetable = null;
            while (calorie > 0 && !vegetables.isEmpty()) {
                vegetable = vegetables.pop();
                int veg = salad.get(vegetable);
                calorie -= veg;


            }



        }

        System.out.println(readySalad.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        if (!vegetables.isEmpty()){
            System.out.println(vegetables.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
        if (!calories.isEmpty()){
            System.out.println(calories.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}
