package bg.softuni.fundamentals.Basyc.Syntax;

import java.util.Scanner;

public class ForeignLanguages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String output = "";

        switch (name) {
            case "USA":
            case "England":
                output = "English";
                break;
            case "Spain":
            case "Argentina":
            case "Mexico":
                output = "Spanish";
                break;
            default:
                output = "unknown";
                break;

        }
        System.out.println(output);
    }
}
