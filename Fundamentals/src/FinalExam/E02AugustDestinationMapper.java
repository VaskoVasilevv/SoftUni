package FinalExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E02AugustDestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String placesStr = scanner.nextLine();
        String regex = "([=/])([A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(placesStr);
        List<String> location = new ArrayList<>();
        while (matcher.find()) {
            location.add(matcher.group(2));
        }

        System.out.println("Destinations: "+ String.join(", ",location));
        System.out.println("Travel Points: " + location.stream().mapToInt(l -> l.length()).sum());

    }
}
