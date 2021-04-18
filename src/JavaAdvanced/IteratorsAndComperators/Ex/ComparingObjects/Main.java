package JavaAdvanced.IteratorsAndComperators.Ex.ComparingObjects;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        String   input = scanner.nextLine();
        while (!input.equals("END")){
            String[] tokens = input.split("\\s+");

            people.add(new Person(tokens[0],Integer.parseInt(tokens[1]),tokens[2]));

            input = scanner.nextLine();
        }

        int index = Integer.parseInt(scanner.nextLine())-1;
        Person person = people.get(index);

        int count = 0;

        for (Person p : people) {
            if (p.compareTo(person) == 0){
                count++;
            }
        }

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return 0;
            }
        });

        if (count == 1){
            System.out.println("No matches");
        }else {
            System.out.println(String.format("%d %d %d",count,people.size()-count,people.size()));
        }
    }
}
