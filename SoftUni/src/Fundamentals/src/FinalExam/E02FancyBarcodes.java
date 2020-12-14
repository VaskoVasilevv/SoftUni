package bg.softuni.fundamentals.FinalExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E02FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("@#+(?<item>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                Pattern digitPattern = Pattern.compile("\\d");
                Matcher digitMatcher = digitPattern.matcher(input);
                StringBuilder result = new StringBuilder();
                while (digitMatcher.find()) {
                    result.append(digitMatcher.group());
                }
                if (result.toString().equals("")) {
                    result = new StringBuilder("00");
                }
                System.out.println("Product group: " + result);
            }else {
                System.out.println("Invalid barcode");
            }

        }
    }
}
