package bg.softuni.fundamentals.TextProcessing;

import java.util.Scanner;

public class E02AsciiSumatorMoreEX {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String a = scanner.nextLine();
        String b = scanner.nextLine();
        String text = scanner.nextLine();
        int sum = 0;

        for (int i = 0; i < text.length(); i++) {
            int cur = text.charAt(i);
            int first = a.charAt(0);
            int second = b.charAt(0);
            if (cur > first && cur < second) {
                sum += cur;
            }
        }
        System.out.println(sum);
    }
}


