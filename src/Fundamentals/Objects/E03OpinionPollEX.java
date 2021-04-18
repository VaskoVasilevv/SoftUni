package Fundamentals.Objects;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E03OpinionPollEX {

    static class Person {
        String name;
        int age;

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return String.format("%s - %d", getName(), getAge());
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> allPersons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            Person person = new Person(name, age);
            allPersons.add(person);

        }
        allPersons.stream().filter(person -> person.getAge()> 30)
                .sorted((p1,p2) ->p1.getName().compareTo(p2.getName()))
                .forEach(person -> System.out.println(person.toString()));


    }
}
