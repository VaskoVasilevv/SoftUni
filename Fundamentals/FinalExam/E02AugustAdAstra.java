package bg.softuni.fundamentals.FinalExam;

import org.w3c.dom.CDATASection;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E02AugustAdAstra {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("([|#])(?<name>[A-Za-z]+\\s*[A-Za-z]*)\\1(?<date>\\d{2}\\/\\d{2}\\/\\d{2})\\1(?<calories>\\d+)\\1");
        Matcher matcher = pattern.matcher(input);
        int  totalCal = 0;
        while (matcher.find()){
          totalCal += Integer.parseInt(matcher.group("calories"));
        }
        System.out.println("You have food to last you for: " + totalCal / 2000 +" days!");
        matcher = pattern.matcher(input);
        while (matcher.find()){
            String name = matcher.group("name");
            String date = matcher.group("date");
            String nutrition = matcher.group("calories");
            System.out.printf("Item: %s, Best before: %s, Nutrition: %s%n",name,date,nutrition);
        }
    }
}
