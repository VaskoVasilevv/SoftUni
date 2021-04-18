package ProgrammingBasics.LastProjeckt;

import java.util.Scanner;

public class ReadText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int n = 0;

        while (!input.equals("Stop")) {
            input = scanner.nextLine();
            n++;
        }
        System.out.println(n);
    }
}
