package bg.softuni.fundamentals.Data.Types;

import java.util.Scanner;

public class SpiceMustFlowEX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());
        int days = 0;
        int totoalAmount = 0;
        while (startingYield >= 100) {
            totoalAmount += (startingYield - 26);

            days ++;
            startingYield -= 10;
        }
        if (totoalAmount > 26) {
            totoalAmount -= 26;
        }
        System.out.println(days);
        System.out.println(totoalAmount);
    }
}
