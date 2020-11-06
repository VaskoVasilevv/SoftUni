package bg.softuni.fundamentals.MidEXAM;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E03EasterShopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String command = tokens[0];
            switch (command) {
                case "Include":
                    names.add(tokens[1]);
                    break;
                case "Visit":
                    int index = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < names.size() ) {
                        if (tokens[1].equals("first")) {

                            for (int j = 0; j < Integer.parseInt(tokens[2]); j++) {
                                names.remove(0);
                            }
                        } else {
                            for (int j = 0; j < Integer.parseInt(tokens[2]); j++) {
                                names.remove(names.size() - 1);

                            }
                        }
                    }
                    break;
                case "Prefer":
                    int firstShopIndex = Integer.parseInt(tokens[1]);
                    int secondShopIndex = Integer.parseInt(tokens[2]);
                    if (firstShopIndex >= 0 && secondShopIndex >= 0 && firstShopIndex < names.size() && secondShopIndex < names.size()) {
                        String oldfirst = names.get(firstShopIndex);
                        String oldsecond = names.get(secondShopIndex);
                        names.set(firstShopIndex, oldsecond);
                        names.set(secondShopIndex, oldfirst);

                    }
                    break;
                case "Place":
                    int index1 = Integer.parseInt(tokens[2]);
                    if (index1 >= 0 && index1 < names.size()-1) {
                        names.add((index1 + 1), tokens[1]);
                        break;
                    }
            }

        }
        System.out.println("Shops left:");
        System.out.print(String.join(" ", names));
    }
}
