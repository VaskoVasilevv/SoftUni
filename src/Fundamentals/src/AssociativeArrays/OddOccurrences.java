package AssociativeArrays;

import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");

        Map<String, Integer> count = new LinkedHashMap<>();

        for (String word : words) {
            String wordInLowerCase = word.toLowerCase();
            if (count.containsKey(wordInLowerCase)){
                count.put(wordInLowerCase,count.get(wordInLowerCase)+ 1);

            }else {
                count.put(wordInLowerCase,1);
            }
        }
        List<String> odds = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() % 2 == 0){
                odds.add(entry.getKey());
            }
        }
        for (int i = 0; i < odds.size(); i++) {
            System.out.print(odds.get(i));
            if (i < odds.size() -1){
                System.out.print(", ");
            }

        }


    }
}
