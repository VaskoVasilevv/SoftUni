package bg.softuni.fundamentals.TextProcessing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //             01234567890123456
//        String text = "Hello and goodbye";
//        int courrentIndex = text.indexOf("o");
//        while (courrentIndex != -1){
//            System.out.println(courrentIndex);
//
//            courrentIndex =text.indexOf("o",courrentIndex+1);
//        }

//        List<Character> letterList = new ArrayList<>();
//        String line = scanner.nextLine();
//        while (!line.equals("end")){
//            letterList.add(line.charAt(0));
//            line = scanner.nextLine();
//        }
//        String output = new String(lettersArray);
//        System.out.println(output.toUpperCase());
    }

//      Конвертиране на List<Character> към char[]!!!!
    private static char[] getCharArray(List<Character> charList) {
        char[] lettersArray = new char[charList.size()];
        for (int i = 0; i < lettersArray.length; i++) {
            lettersArray[i] = charList.get(i);
        }
        return lettersArray;
    }

//      Повтаряне на String Count на брой пъти
    private static String repeat(String word, int count) {
        String[] repeatArr = new String[count];
        for (int i = 0; i < count; i++) {
            repeatArr[i] = word;

        }
        return String.join("", repeatArr);
    }

    private static String repeatWithStringBuilder(String word, int count) {
        StringBuilder repeated = new StringBuilder();
        for (int i = 0; i < count; i++) {
            repeated.append(word);
        }
        return repeated.toString();
    }
}
