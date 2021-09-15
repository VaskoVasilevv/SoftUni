package DefendingClasses.Ex.OpinionPool;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Person> personMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]));
            personMap.put(tokens[0], person);
        }

        personMap.entrySet().stream()
                .filter(age -> age.getValue().getAge() > 30)
                .sorted((f, s) -> f.getKey().compareTo(s.getKey()))
                .forEach(e -> System.out.println(String.format("%s - %d", e.getKey(), e.getValue().getAge())));
    }
}
