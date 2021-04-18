package Fundamentals.FinalExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E02AprilEmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = "([*]{2}|[:]{2})[A-Z][a-z]{2,}\\1";
        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(text);

        List<String> emoji = new ArrayList<>();


        while (matcher.find()){
            emoji.add(matcher.group());
        }
        long cools =1;
        for (int i = 0; i < text.length(); i++) {
            char digit = text.charAt(i);
            if (Character.isDigit(digit)){
                cools *= digit - '0';
            }
        }
        System.out.println("Cool threshold: " + cools);
        System.out.printf("%d emojis found in the text. The cool ones are: %n",emoji.size());
        for (int i = 0; i < emoji.size(); i++) {
        long sum = 0;
            for (int j = 2; j < emoji.get(i).length()-2 ; j++) {
                char symbol = emoji.get(i).charAt(j) ;
                sum += symbol;
            }
            if (sum >= cools){
                System.out.println(emoji.get(i).trim());
            }

        }

    }
}
