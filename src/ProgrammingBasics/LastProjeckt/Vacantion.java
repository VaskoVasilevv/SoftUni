package ProgrammingBasics.LastProjeckt;

import java.util.Scanner;

public class Vacantion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double target = Double.parseDouble(scanner.nextLine());
        double startMoney = Double.parseDouble(scanner.nextLine());
        int spendCount = 0;
        int daysCounter = 0;

        while (startMoney < target) {
            String activity = scanner.nextLine();
            double money = Double.parseDouble(scanner.nextLine());
            daysCounter++;

            if ("spend".equals(activity)) {
                if (startMoney - money > money) {
                    startMoney -= money;
                } else {
                    startMoney = 0;
                }
                spendCount++;
                if (spendCount == 5) {
                    break;
                }
            } else if ("save".equals(activity)) {
                startMoney += money;
                spendCount = 0;

            }
        }
        if (spendCount == 5) {
            System.out.println("You can't save the money.");
            System.out.println(daysCounter);
        } else {
            System.out.printf("You saved the money for %d days.", daysCounter);
        }
    }
}
