package FinalExam;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E02MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("([#@])(?<first>[a-zA-z]{3,})\\1\\1(?<second>[a-zA-z]{3,})\\1");
        Matcher matcher = pattern.matcher(input);
        int count = 0;
        int mirror = 0;
        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            count++;
        }
        if (count != 0) {
            System.out.printf("%d word pairs found!%n", count);
        } else {
            System.out.println("No word pairs found!");
        }
        matcher = pattern.matcher(input);
        while (matcher.find()) {
            String first = matcher.group("first");
            String second = matcher.group("second");
            StringBuilder secondRevers = new StringBuilder(second);
            secondRevers.reverse();
            String string = "";
            if (first.equals(String.valueOf(secondRevers))) {
                string = first + " <=> " + second;
                list.add(string);
                mirror++;
            }
        }
        if (mirror != 0) {
            System.out.println("The mirror words are:");
            System.out.print(String.join(", ", list));
        } else {
            System.out.println("No mirror words!");
        }
    }
}