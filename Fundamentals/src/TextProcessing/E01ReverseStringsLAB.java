package TextProcessing;

import java.util.Scanner;

public class E01ReverseStringsLAB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String word = "";
            for (int i = input.length() - 1; i >= 0; i--) {
                word += input.charAt(i);
            }
            System.out.println(input+ " = " + word);
            input = scanner.nextLine();


        }
    }
}
