package Objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E07OrderByAgeEX {
    static class Person {

        String name;
        String ID;
        int age;

        public Person(String name, String ID, int age) {
            this.name = name;
            this.ID = ID;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getID() {
            return ID;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return String.format("%s with ID: %s is %d years old.", getName(), getID(), getAge());
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        List<Person> allPersons = new ArrayList<>();

        while (!line.equals("End")) {

            String[] data = line.split(" ");
            String name = data[0];
            String ID = data[1];
            int age = Integer.parseInt(data[2]);

            Person person = new Person(name, ID, age);
            allPersons.add(person);


            line = scanner.nextLine();
        }
        allPersons.stream().sorted((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()))
                .forEach(person -> System.out.println(person.toString()));


    }
}
