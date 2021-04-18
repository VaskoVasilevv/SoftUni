package Fundamentals.MidEXAM;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E02EasterGifts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> gifts = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("No Money")) {
            String[] namesOfGifts = input.split(" ");
            String command = namesOfGifts[0];
            switch (command) {
                case "OutOfStock":
                    for (int i = 0; i < gifts.size(); i++) {
                        if (gifts.get(i).contains(namesOfGifts[1])){
                            gifts.set(i, "None");
                        }
                    }
                    break;
                case "Required":
                    int index =Integer.parseInt(namesOfGifts[2]);
                    String replace = namesOfGifts[1];
                    if (index >= 0 && index < gifts.size()){
                        gifts. set(index,replace);
                    }
                    break;
                case "JustInCase":
                    gifts.set(gifts.size()-1,namesOfGifts[1]);
                    break;
            }


            input = scanner.nextLine();
        }
        for (int i = 0; i < gifts.size(); i++) {
            if (gifts.get(i).equals("None")){
                System.out.print("");
            }else {
                System.out.print(gifts.get(i)+ " ");
            }

        }

    }
}
