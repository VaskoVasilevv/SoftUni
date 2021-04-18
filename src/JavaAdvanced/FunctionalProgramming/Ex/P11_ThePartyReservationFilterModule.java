package JavaAdvanced.FunctionalProgramming.Ex;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11_ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guest = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Map<String, Predicate<String>> predicates = new HashMap<>();
        String input;


        while (!"Print".equals(input = scanner.nextLine())) {
            String[] tokens = input.split(";");
            String predicateName = tokens[1] + tokens[2];

            switch (tokens[0]) {
                case "Add filter":
                    Predicate<String> predicate = getPredicat(tokens);
                    predicates.put(predicateName, predicate);
                    break;
                case "Remove filter":
                    predicates.remove(predicateName);
                    break;
            }

        }

        guest.stream().filter(gest -> {
            boolean isValid = true;
            for (Predicate<String> predicate : predicates.values()) {
                if (predicate.test(gest)){
                    isValid = false;
                    break;
                }


            }
            return isValid;

        }).forEach(e-> System.out.print(e+" "));
    }

    private static Predicate<String> getPredicat(String[] tokens) {
        Predicate<String> predicate = null;
        if (tokens[1].equals("Starts With")) {
            predicate = name -> name.startsWith(tokens[2]);
        } else if (tokens[1].equals("Ends With")) {
            predicate = name -> name.endsWith(tokens[2]);
        } else if (tokens[1].equals("Length")) {
            predicate = name -> name.length() == Integer.parseInt(tokens[2]);
        } else {
            predicate = name -> name.contains(tokens[2]);
        }


        return predicate;
    }
}
