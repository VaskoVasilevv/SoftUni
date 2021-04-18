package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRopeMORE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();


        List<String> text = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                numbers.add(Integer.parseInt(String.valueOf(input.charAt(i))));
            } else {
                text.add(String.valueOf(input.charAt(i)));
            }

        }
        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(numbers.get(i));
            } else {
                skipList.add(numbers.get(i));
            }

        }
        int index = 0;
        String result = "";

        while (index < takeList.size()) {

            int take = takeList.get(index);
            int skip = skipList.get(index);


            if (take < text.size()) {
                for (int i = 0; i < take; i++) {
                    result += text.get(i);
                }

                for (int i = 0; i < take; i++) {
                    text.remove(0);
                }
                for (int i = 0; i < skip; i++) {
                    text.remove(0);
                }
            } else {
                for (String element : text
                ) {
                    result += element;
                }
            }

            index++;
        }
        System.out.println(result);

    }
}



