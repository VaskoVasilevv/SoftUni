package JavaAdvanced.FunctionalProgramming.Lab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P05_FilterByAge {
    public static class Persone {
        String name;
        int age;

        public Persone(String name, int age) {
            this.name = name;
            this.age = age;
        }

    }

    public static void main(String[] args) throws IllegalAccessException {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Function<String, Persone> parsePErsone = str -> {
            String[] tokens = str.split(", ");
            return new Persone(tokens[0], Integer.parseInt(tokens[1]));
        };
        List<Persone> people = new ArrayList<>();

        while (n-- > 0) {
            people.add(parsePErsone.apply(scanner.nextLine()));
        }

        String condition = scanner.nextLine();
        int ageCondition = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        people = condition.equals("older") ?
                filterPeople(people, p -> p.age >= ageCondition)
                : filterPeople(people, p -> p.age <= ageCondition);

        System.out.println(formatedPeople(people, getForrmaterFunction(format), System.lineSeparator()));
    }

    private static Function<Persone, String> getForrmaterFunction(String format) throws IllegalAccessException {
        switch (format) {
            case "name":
                return p -> p.name;
            case "age":
                return p -> String.valueOf(p.age);
            case "name age":
                return p -> p.name + " - " + p.age;
            default:
                throw new IllegalAccessException("Uncknown format"+ format);

        }
    }

    public static String formatedPeople(Collection<Persone> people, Function<Persone, String> formatter, String delimiter) {
        return people.stream()
                .map(p -> formatter.apply(p))
                .collect(Collectors.joining(delimiter));
    }

    public static List<Persone> filterPeople(Collection<Persone> people, Predicate<Persone> predicate) {
        return people.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
