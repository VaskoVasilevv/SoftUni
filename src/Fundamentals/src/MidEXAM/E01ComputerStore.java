package MidEXAM;

import java.util.Scanner;

public class E01ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double price = 0;
        double taxes = 0;
        while ((!input.equals("special") && !input.equals("regular"))) {
            double currentPrice = Double.parseDouble(input);
            if (currentPrice < 0) {
                System.out.println("Invalid price!");
            } else {
                price += currentPrice;
                taxes += currentPrice * 0.2;
            }


            input = scanner.nextLine();
        }
        double totalPrice = price + taxes;
        if (input.equals("special")) {
            totalPrice = totalPrice - totalPrice * 0.1;

        }
        if (totalPrice == 0) {
            System.out.println("Invalid order!");
        } else {
            System.out.printf("Congratulations you've just bought a new computer!%nPrice without taxes: %.2f$%nTaxes: %.2f$%n", price, taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$", totalPrice);
        }


    }
}
