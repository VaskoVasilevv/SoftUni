package FinalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        int count = 0;
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Pattern pattern = Pattern.compile("U\\$(?<username>[A-Z][a-z]{2,})U\\$P@\\$(?<pass>[A-z]{5,}\\d+)P@\\$");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                count ++;
                System.out.println("Registration was successful");
                System.out.println("Username: " + matcher.group("username")+", " + "Password: " + matcher.group("pass") );
            }else {
                System.out.println("Invalid username or password");
            }

        }
        System.out.println("Successful registrations: " + count);


    }
}
