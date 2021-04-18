package Fundamentals.TextProcessing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E02RepeatStringsLAB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split(" ");
        List<String> wordsList = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            wordsList.add(repeat(words[i], words[i].length()))  ;
        }
        System.out.print(String.join("",wordsList));
    }

    private static String repeat(String word, int count) {
        String[] repeatArr = new String[count];
        for (int i = 0; i < count; i++) {
            repeatArr[i] = word;

        }
        return String.join("", repeatArr);
    }
}
