package FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        Pattern pattern = Pattern.compile("^([\\$%])(?<tag>[A-Z][a-z]{3,})\\1: \\[(?<firstGroup>\\d+)\\]\\|\\[(?<secondGroup>\\d+)\\]\\|\\[(?<thirdGroup>\\d+)\\]\\|$");

        for (int i = 0; i <= n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                int first = Integer.parseInt(matcher.group("firstGroup"));
                int second = Integer.parseInt(matcher.group("secondGroup"));
                int third = Integer.parseInt(matcher.group("thirdGroup"));
                System.out.printf("%s: %c%c%c%n", matcher.group("tag"), first, second, third);
            } else {
                System.out.println("Valid message not found!");
            }

        }
    }
}
