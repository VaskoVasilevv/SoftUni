package Data.Types;

import java.util.Scanner;

public class PrintPartOfTheASCIITableEX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        for (int i = a; i <= b; i++) {
            System.out.printf("%c ",i);
        }
    }
}
