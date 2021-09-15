package TextProcessing;

import java.util.Scanner;

public class E08LettersChangeNumbersEX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        double sum = 0;

        for (String input : tokens) {
            char firstLetter = input.charAt(0);
            char secondLetter = input.charAt(input.length() - 1);
            double number = Integer.parseInt(input.substring(1, input.length() - 1));

            int firstLetterPosition = getLetterAlphabet(firstLetter);
            int secondLetterPosition = getLetterAlphabet(secondLetter);

            if (Character.isUpperCase(firstLetter)){
               sum  += number / firstLetterPosition;
            }else {
                sum += number * firstLetterPosition;
            }
            if (Character.isUpperCase(secondLetter)){
                sum -= secondLetterPosition;
            }else {
                sum += secondLetterPosition;
            }

        }
        System.out.printf("%.2f",sum);

    }

    private static int getLetterAlphabet(char c) {
        char targetChar = Character.toLowerCase(c);
        char initial = 'a';
        int position = targetChar - initial + 1;

        return position;
    }
}
