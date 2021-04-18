package bg.softuni.fundamentals.AssociativeArrays;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> phonebook = new HashMap<>();

        phonebook.put("Pesho", 123);
        phonebook.put("Pesho1", 1232);
        phonebook.put("Gosho", 123);
        phonebook.put("Pesho2", 12323);
        phonebook.put("Pesho3", 123233);
        phonebook.put("Pesho4", 1233421);
        phonebook.put("Pepi", 1233421);

        for (Map.Entry<String, Integer> entry : phonebook.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());

        }
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());

        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .sorted((l,r) -> l - r)
                .collect(Collectors.toList());

        Map<Integer, String> products = new HashMap<>();
        products.entrySet()
                .stream()
                .sorted((e1,e2) -> { int res = e2.getValue().compareTo(e1.getValue());
                if (res == 0)
                res = e1.getKey().compareTo(e2.getKey());
                return res;})
                .forEach(e -> System.out.println(e.getKey()+ " "));

        phonebook.entrySet().stream()
                .sorted((l,r) -> {
                    int leftLen = l.getKey().length();
                    int rightLen = r.getKey().length();

                    return leftLen - rightLen;
                })
                .collect(Collectors.toList());


    }
}
