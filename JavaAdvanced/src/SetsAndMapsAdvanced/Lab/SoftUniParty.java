package SetsAndMapsAdvanced.Lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        String input = scanner.nextLine();

        while (!input.equals("PARTY")){

            if (Character.isDigit(input.charAt(0))){
                vip.add(input);
            }else {
                regular.add(input);
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();

        while (!input.equals("END")){

            if (Character.isDigit(input.charAt(0))){
                vip.remove(input);
            }else {
                regular.remove(input);
            }
            input = scanner.nextLine();
        }
        System.out.println(vip.size() + regular.size());
        vip.stream().forEach(e -> System.out.println(e));
        regular.stream().forEach(e -> System.out.println(e));

    }
}
