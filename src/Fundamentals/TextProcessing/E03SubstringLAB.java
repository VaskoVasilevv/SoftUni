package Fundamentals.TextProcessing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E03SubstringLAB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        String text = scanner.nextLine();

//        int currentIndex = 0;
//        int nextWordIndex = text.indexOf(word, currentIndex);
//        List<String> substrings = new ArrayList<>();
//        while (nextWordIndex != -1) {
//            substrings.add(text.substring(currentIndex, nextWordIndex));
//            currentIndex = nextWordIndex + word.length();
//            nextWordIndex = text.indexOf(word, currentIndex);
//
//        }
//        substrings.add(text.substring(currentIndex));
//        String result = String.join("",substrings);
//        System.out.println(result);

        int index = text.indexOf(word);
        while (index != -1) {
            text = text.replace(word, "");
            index = text.indexOf(word);
        }
        System.out.println(text);
    }
}
