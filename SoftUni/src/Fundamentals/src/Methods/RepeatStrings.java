package bg.softuni.fundamentals.Methods;

import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        int repetitionsCount = Integer.parseInt(scanner.nextLine());

        String repeated = repead(s,repetitionsCount);

        System.out.print(repeated);
    }
    static String repead(String s,int count){
        String [] repetitions = new String[count];
        for (int i = 0; i < count; i++) {
            repetitions[i] = s;

        }
        String repeated = String.join("",repetitions);
        return repeated;
    }
}
