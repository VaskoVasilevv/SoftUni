package SetsAndMapsAdvanced.EX;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        Map<String, String> phonebook = new LinkedHashMap<>();
        while (!input.equals("search")){
            String[] tokens = input.split("-");
            phonebook.put(tokens[0],tokens[1]);
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("stop")){

            if (!phonebook.containsKey(input)){
                System.out.println("Contact "+ input +" does not exist.");
            }else if (phonebook.containsKey(input)) {
                System.out.println(input+" -> "+phonebook.get(input));
            }

            input = scanner.nextLine();
        }
    }
}
