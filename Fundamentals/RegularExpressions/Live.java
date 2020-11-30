package bg.softuni.fundamentals.RegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Live {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = "\\b(?<day>\\d\\d?)-(?<month>[A-Z][a-z]{2})-(?<year>\\d{4})\\b";
        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println(matcher.group("day"));

        }



//        String expression = "[A-Z][A-Za-z]+";
//        String text = scanner.nextLine();
//
//        Pattern pattern = Pattern.compile(expression);
//        Matcher matcher = pattern.matcher(text);
//
//        while (matcher.find()){
//        System.out.println(matcher.group());
//        }

//        3.14 420 690 13
//        \d+(\.\d+)?


//        ---113--- ***29*** 420 ---6*** ***9---
//        ([-*]{3})\d+\1


//        e-mail
//        ^\w+@[A-Za-z]+\.[A-Za-z]+$


//        date
//        \b(?<day>\d\d?)-(?<month>[A-Z][a-z]{2})-(?<year>\d{4})\b



        //        [A-Z][a-z]+([A-Z][a-z]+)+
        //        ([A-Z][a-z]+){2,3}


//        String text = scanner.nextLine();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < text.length(); i++) {
//            char symbol = text.charAt(i);
//
//
//            if (Character.isDigit(symbol)){
//                sb.append(symbol);
//
//            }else if(sb.length()!= 0){
//                System.out.println(sb);
//                sb = new StringBuilder();
//            }
//
//        }
//        if(sb.length()!= 0){
//            System.out.println(sb);
//            sb = new StringBuilder();
//        }
    }
}
