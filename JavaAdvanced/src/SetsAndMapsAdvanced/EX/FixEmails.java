package SetsAndMapsAdvanced.EX;

import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputname = scanner.nextLine();

        while (!inputname.equals("stop")) {
            String inputline = scanner.nextLine();
            if (!inputline.endsWith(".us") && !inputline.endsWith(".uk") && !inputline.endsWith(".com")) {
                System.out.printf("%s -> %s%n",inputname,inputline);
            }

            inputname = scanner.nextLine();
        }
    }
}
