package JavaAdvanced.IteratorsAndComperators.Ex.StrategyPattern;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Person> peopleByAge = new TreeSet<>(new PersonComparatorByAge());
        Set<Person> peopleByName = new TreeSet<>(new PersonSortByName());
        int count = Integer.parseInt(scanner.nextLine());

        while (count-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            Person p = new Person(tokens[0],Integer.parseInt(tokens[1]));

            peopleByAge.add(p);
            peopleByName.add(p);

        }
        for (Person person : peopleByName) {
            System.out.println(person);
        }

        for (Person person : peopleByAge) {
            System.out.println(person);
        }
    }
}
