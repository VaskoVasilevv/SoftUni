package FunctionalProgramming.Ex;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10_PredicateParty {

    static List<String> names = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input;
        while (!"Party!".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {
                case "Remove":
                    removeName(getPredicate(tokens));
                    break;
                case "Double":
                    addoneMore(getPredicate(tokens));
                    break;


            }
        }
        Collections.sort(names);
        if (names.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else {
            System.out.println(names.toString().replaceAll("([\\[\\]])", "") + " are going to the party!");
        }
    }

    private static void removeName(Predicate<String> predicate) {
        names.removeIf(predicate);
    }

    private static void addoneMore(Predicate<String> predicate) {
        List<String> nameToAdd= new ArrayList<>();
        names.stream().filter(predicate).forEach(nameToAdd::add);
        names.addAll(nameToAdd);
    }

    private static Predicate<String> getPredicate(String[] tokens) {
        Predicate<String> predicate = null;
        if (tokens[1].equals("StartsWith")) {
            predicate = name -> name.startsWith(tokens[2]);
        } else if (tokens[1].equals("EndsWith")) {
            predicate = name -> name.endsWith(tokens[2]);
        } else {
            predicate = name -> name.length() == Integer.parseInt(tokens[2]);
        }


        return predicate;
    }
}
