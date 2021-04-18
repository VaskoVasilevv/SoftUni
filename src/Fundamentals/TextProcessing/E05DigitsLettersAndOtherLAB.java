package Fundamentals.TextProcessing;

import java.util.Arrays;
import java.util.Scanner;

public class E05DigitsLettersAndOtherLAB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String numbers = "";
        String letters = "";
        String chars = "";
        for (int i = 0; i < input.length(); i++) {
            Character symbol = input.charAt(i);
            if (Character.isDigit(symbol)){
                numbers+=symbol;
            }else if (Character.isLetter(symbol)){
                letters+= symbol;
            }else {
                chars+= symbol;
            }

        }
        System.out.println(numbers);
        System.out.println(letters);
        System.out.println(chars);


    }

}
