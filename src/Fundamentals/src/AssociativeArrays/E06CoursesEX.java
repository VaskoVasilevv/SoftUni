package AssociativeArrays;

import java.util.*;

public class E06CoursesEX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> courses = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] tokens = input.split(" : ");
            String courseName = tokens[0];
            String students = tokens[1];

            if (!courses.containsKey(courseName)) {
                courses.put(courseName, new LinkedList<>());
            }
            courses.get(courseName).add(students);
            input = scanner.nextLine();
        }

        courses.entrySet().stream()
                .sorted((f,s) -> s.getValue().size() - f.getValue().size())
                .forEach(e -> {
                    System.out.println(e.getKey() + ": " + e.getValue().size());
                    e.getValue()
                            .stream()
                            .sorted((f,s)-> f.compareTo(s))
                            .forEach(s -> System.out.println("-- "+ s));
                });
    }
}
