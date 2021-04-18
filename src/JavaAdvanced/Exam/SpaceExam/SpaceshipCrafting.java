package JavaAdvanced.Exam.SpaceExam;

import java.util.*;

public class SpaceshipCrafting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] liquidArray = ReadIntegerArray(scanner);
        int[] itemsArray = ReadIntegerArray(scanner);

        ArrayDeque<Integer> liquids = ParseQueue(liquidArray);
        ArrayDeque<Integer> items = ParseStack(itemsArray);

        Map<String, Integer> advancedMaterials = new TreeMap<>();
        advancedMaterials.put("Aluminium", 0);
        advancedMaterials.put("Carbon fiber", 0);
        advancedMaterials.put("Lithium", 0);
        advancedMaterials.put("Glass", 0);

        while (!(liquids.isEmpty() || items.isEmpty())) {
            int currentLiquid = liquids.poll();

            int currentItem = items.pop();

            int advanceMaterialSum = currentItem + currentLiquid;
            String advanceMaterial = getAdvancedMaterila(advanceMaterialSum);


            if (advanceMaterial == null) {
                items.push(currentItem + 3);
            } else {
                advancedMaterials.put(advanceMaterial, advancedMaterials.get(advanceMaterial) + 1);
            }

        }
        if (advancedMaterials.entrySet().stream().allMatch(e -> e.getValue()>0)){
            System.out.println("Wohoo! You succeeded in building th spaceship!");
        }else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to build the spaceship.");
        }

        String liquidResult = "Liquids left: ";

        if (liquids.isEmpty()){
            liquidResult += "none" ;
        }else {
            liquidResult += joinQueue(liquids);
        }
        System.out.println(liquidResult);


        String itemsResult = "Physical items left: ";

        if (items.isEmpty()){
            itemsResult += "none" ;
        }else {
            itemsResult += joinStack(items);
        }
        System.out.println(itemsResult);

        for (Map.Entry<String, Integer> advanceMaterial : advancedMaterials.entrySet()) {
            System.out.println(advanceMaterial.getKey() + ": " + advanceMaterial.getValue());


        }
    }

    private static String joinStack(ArrayDeque<Integer> items) {
        StringBuilder sb = new StringBuilder();
        while (!items.isEmpty()){
            sb.append(items.pop());
            if (items.isEmpty()){
                break;
            }
            sb.append(", ");
        }
        return sb.toString().trim();
    }

    private static String joinQueue(ArrayDeque<Integer> liquids) {
        StringBuilder sb = new StringBuilder();
        while (!liquids.isEmpty()){
            sb.append(liquids.poll());
            if (liquids.isEmpty()){
                break;
            }
            sb.append(", ");
        }
        return sb.toString().trim();
    }

    private static String getAdvancedMaterila(int advanceMaterialSum) {
        String advanceMaterial = null;

        switch (advanceMaterialSum) {
            case 25:
                advanceMaterial = "Glass";
                break;
            case 50:
                advanceMaterial = "Aluminium";
                break;
            case 75:
                advanceMaterial = "Lithium";
                break;
            case 100:
                advanceMaterial = "Carbon fiber";
                break;
        }
        return advanceMaterial;
    }


    private static int[] ReadIntegerArray(Scanner scanner) {
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        return arr;
    }

    private static ArrayDeque<Integer> ParseQueue(int[] liquidArray) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int element : liquidArray) {
            queue.offer(element);
        }
        return queue;
    }

    private static ArrayDeque<Integer> ParseStack(int[] liquidArray) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int element : liquidArray) {
            stack.push(element);
        }
        return stack;
    }
}
