package JavaAdvanced.Generics.Ex.CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        SmartList<String> smartList = new SmartList<>();

        String line = scanner.nextLine();

        while (!line.equals("END")) {
            String[] tokens = line.split("\\s+");
            switch (tokens[0]) {

                case "Add":
                    smartList.add(tokens[1]);
                    break;
                case "Remove":
                    smartList.remove(Integer.parseInt(tokens[1]));
                    break;
                case "Contains":
                    System.out.println(smartList.contains(tokens[1]));
                    break;
                case "Swap":
                    smartList.swap(Integer.parseInt(tokens[1])
                            ,Integer.parseInt(tokens[2]));
                    break;
                case "Greater":
                    System.out.println(smartList.countGreaterThan(tokens[1]));
                    break;
                case "Max":
                    System.out.println(smartList.getMax());
                    break;
                case "Min":
                    System.out.println(smartList.getMin());
                    break;
                case "Print":
                    smartList.forEach(System.out::println);
                    break;
            }

            line = scanner.nextLine();
        }
    }
}
