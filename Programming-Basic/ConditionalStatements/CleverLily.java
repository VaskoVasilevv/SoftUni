import java.util.Scanner;

public class CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int age = Integer.parseInt(scanner.nextLine());
        double priceWashMachine = Double.parseDouble(scanner.nextLine());
        int priceToy = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        int money = 0;
        int counter = 0;

        for (int i = 1; i <= age; i++) {

            if (i % 2 == 0) {
                money = money + 10;
                sum = sum + money;
                counter = counter + 1;
            } else {
                sum = sum + priceToy;

            }

        }
        double savedMoney = sum - counter;

        double diff = Math.abs(savedMoney - priceWashMachine);

        if (savedMoney >= priceWashMachine) {
            System.out.printf("Yes! %.2f", diff);
        } else {
            System.out.printf("No! %.2f", diff);

        }

    }
}
