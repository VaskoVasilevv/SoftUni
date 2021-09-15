package AssociativeArrays;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E01CountCharsInAStringEX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Character, Integer> outputs = new LinkedHashMap<>();

        for (char c : input.toCharArray()) {
            if (c != ' ') {
                if (outputs.containsKey(c)) {
                    int count = outputs.get(c);
                    outputs.put(c, count + 1);
                } else {
                    outputs.put(c,1 );

                }
            }
        }
        for (Map.Entry<Character, Integer> entry : outputs.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}
