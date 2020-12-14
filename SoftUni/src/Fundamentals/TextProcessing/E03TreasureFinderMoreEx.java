package bg.softuni.fundamentals.TextProcessing;

import java.util.Arrays;
import java.util.Scanner;

public class E03TreasureFinderMoreEx {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int [] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();

        String input = scanner.nextLine();

        while (!"find".equals(input)){
        int key = 0;
        StringBuilder text = new StringBuilder();
            for (int i = 0; i < input.length(); i++) {
                char symbol = input.charAt(i);
                if (key >= numbers.length){
                    key= 0;
                }
                symbol -= numbers[key];
                text.append(symbol);
                    key++;

            }

            String gold = text.substring(text.indexOf("&") + 1, text.lastIndexOf("&"));
            String cordinats = text.substring(text.indexOf("<") + 1, text.indexOf(">"));
            System.out.printf("Found %s at %s%n",gold,cordinats);
            input = scanner.nextLine();
        }
    }
}
