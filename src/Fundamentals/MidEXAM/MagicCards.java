package Fundamentals.MidEXAM;

import java.util.*;
import java.util.stream.Collectors;

public class MagicCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> deck = Arrays.stream(scanner.nextLine().split(":")).collect(Collectors.toList());
        List<String> cards = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("Ready")) {
            String[] token = input.split(" ");
            String command = token[0];
            switch (command) {
                case "Add":

                    if (deck.contains(token[1])) {
                            deck.remove(token[1]);
                            deck.add(token[1]);
                            cards.add(token[1]);

                    } else {
                        System.out.println("Card not found.");
                    }


                    break;
                case "Insert":
                    String cardName = token[1];
                    int index = Integer.parseInt(token[2]);
                    if (index>= 0 && index < deck.size() && deck.contains(cardName)){
                        deck.remove(cardName);
                        deck.add(index,cardName);
                        cards.add(index,cardName);

                    }else {
                        System.out.println("Error!");
                    }
                    break;
                case "Remove":
                     cardName = token[1];
                    if (cards.contains(cardName)){
                        deck.remove(cardName);
                        cards.remove(cardName);
                    }else {
                        System.out.println("Card not found.");
                    }
                    break;
                case "Swap":
                    String cardName1 = token[1];
                    String cardName2 = token[2];



                    int indexOne = cards.indexOf(cardName1);
                    int indexTwo = cards.indexOf(cardName2);
                    int old = deck.indexOf(cardName1);

                    deck.set(indexOne,cardName2);
                    deck.set(indexTwo,cardName1);

                    cards.set(indexOne,cardName2);
                    cards.set(indexTwo,cardName1);

                    break;
                default:
                    Collections.reverse(cards);
                    break;
            }


            input = scanner.nextLine();
        }
        System.out.println(String.join(" ",cards));
    }
}
