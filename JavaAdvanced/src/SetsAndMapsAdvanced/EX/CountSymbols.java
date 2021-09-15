package SetsAndMapsAdvanced.EX;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Character, Integer> ocurrnces = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

//            Variant 1
//            if (!ocurrnces.containsKey(symbol)) {
//                ocurrnces.put(symbol, 1);
//            } else {
//                ocurrnces.put(symbol, ocurrnces.get(symbol) + 1);
//
//            }
//            Variant 2
//            ocurrnces.putIfAbsent(symbol,0);
//            ocurrnces.put(symbol,ocurrnces.get(symbol)+1);

//            variant 3
            int currentValue =  ocurrnces.getOrDefault(symbol,0);
            ocurrnces.put(symbol,currentValue +1);
        }

        ocurrnces.entrySet().forEach(entry ->{
            System.out.println(entry.getKey() + ": "+entry.getValue()+" time/s");
        });
    }
}
