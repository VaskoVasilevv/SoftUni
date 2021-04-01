package LastProjeckt;

import java.util.Scanner;

public class GreaterNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstName = Integer.parseInt(scanner.nextLine());
        int secondName = Integer.parseInt(scanner.nextLine());

        if (firstName > secondName) {
            System.out.println(firstName);
        } else {
            System.out.println(secondName);

        }


    }
}
