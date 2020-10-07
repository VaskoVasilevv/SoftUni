package bg.softuni.fundamentals.Basyc.Syntax;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGameCount = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int headCount = 0;
        int mouseCount = 0;
        int keyboardCount = 0;
        int displayCount = 0;
        int displayCount1 = 0;


        for (int i = 1; i <= lostGameCount; i++) {
            if (i % 2 == 0) {
                headCount++;
            }
            if (i % 3 == 0) {
                mouseCount++;
            }
            if (i % 2 == 0 && i % 3 == 0) {
                keyboardCount ++;
                if (keyboardCount % 2 == 0) {
                    displayCount = 1;
                }
            }
            if (keyboardCount % 2 == 0 && displayCount == 1){
                displayCount1 ++;
                displayCount = 0;
            }
        }
        double rageExpenses = (headCount * headsetPrice) + (mouseCount * mousePrice) + (keyboardCount * keyboardPrice) + (displayCount1 * displayPrice);
        System.out.printf("Rage expenses: %.2f lv.", rageExpenses);
    }
}
