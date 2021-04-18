package Fundamentals.Methods;
import java.util.Scanner;

public class VowelsCountEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.println(getVowels(input));
    }

    private static int getVowels(String input) {

        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            char symbol = Character.toLowerCase(input.charAt(i));

            if (symbol == 'a' || symbol == 'e' || symbol == 'o' || symbol == 'u' || symbol == 'i') {

                counter++;
            }

        }
        return counter;
    }
}
