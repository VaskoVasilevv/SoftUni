package DefendingClasses.Ex.Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String,Person> personMap = new HashMap<>();
        Company company = null;
        Pokemon pokemon = null;
        Parents parents = null;
        Children children = null;
        Car car = null;
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String name = tokens[0];
            personMap.putIfAbsent(name,new Person());
            switch (tokens[1]) {
                case "company":
                    company = new Company(name,tokens[2],tokens[3],Double.parseDouble(tokens[4]));
                    personMap.get(name).setCompany(company);
                    break;
                case "pokemon":
                    pokemon = new Pokemon(name, tokens[2],tokens[3]);
                    personMap.get(name).addPokemon(pokemon);
                    break;
                case "parents":
                    parents = new Parents(name, tokens[2],tokens[3]);
                    personMap.get(name).addParents(parents);
                    break;
                case "children":
                    children = new Children(name, tokens[2],tokens[3]);
                    personMap.get(name).addChildren(children);
                    break;
                case "car":
                    car = new Car(name,tokens[2],tokens[3]);
                    personMap.get(name).setCar(car);
                    break;
            }

            input = scanner.nextLine();
        }
        input= scanner.nextLine();

        System.out.println(input);
        System.out.println(personMap.get(input).toString());




    }
}
