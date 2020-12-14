package bg.softuni.fundamentals.TextProcessing;


import java.util.Scanner;

public class E01ExtractPersonInformationMoreEX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            String name = input.substring(input.indexOf("@") + 1, input.indexOf("|"));
            String age = input.substring(input.indexOf("#") + 1, input.indexOf("*"));

            System.out.println(name+ " is " + age + " years old.");
        }
    }
}
