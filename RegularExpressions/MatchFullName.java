package bg.softuni.fundamentals.RegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        [A-Z][a-zA-Z]*

//
        String expression = "\\b[A-Z][a-z]+ [A-Z][a-z]+\\b";
        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            System.out.print(matcher.group()+" ");
        }


    }
}
