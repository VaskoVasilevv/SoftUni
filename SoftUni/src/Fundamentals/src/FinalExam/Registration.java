package FinalExam;

import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Pattern pattern = Pattern.compile("^U\\$([A-Z][a-z]{2,})U\\$P@\\$([A-Za-z]{5,}\\d+)P@\\$$");

        int counter = 0;

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                System.out.println("Registration was successful");
                System.out.printf("Username: %s, Password: %s%n", matcher.group(1), matcher.group(2));
                counter++;
            } else {
                System.out.println("Invalid username or password");
            }

        }
        System.out.println("Successful registrations: " + counter);
    }
}
