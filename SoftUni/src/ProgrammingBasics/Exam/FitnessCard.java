import java.util.Scanner;

public class FitnessCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double moneyHave = Double.parseDouble(scanner.nextLine());
        String gender = scanner.nextLine();
        int years = Integer.parseInt(scanner.nextLine());
        String sport = scanner.nextLine();

        double price = 0;

        if ((years >= 5 && years <= 105) && (moneyHave >= 10 && moneyHave < 1000)) {

            if (gender.equals("m")) {
                switch (sport) {
                    case "Gym":
                        price = 42;
                        break;
                    case "Boxing":
                        price = 41;
                        break;
                    case "Yoga":
                        price = 45;
                        break;
                    case "Zumba":
                        price = 34;
                        break;
                    case "Dances":
                        price = 51;
                        break;
                    case "Pilates":
                        price = 39;
                        break;
                }
            } else {
                switch (sport) {
                    case "Gym":
                        price = 35;
                        break;
                    case "Boxing":
                    case "Pilates":
                        price = 37;
                        break;
                    case "Yoga":
                        price = 42;
                        break;
                    case "Zumba":
                        price = 31;
                        break;
                    case "Dances":
                        price = 53;
                        break;

                }
            }
            if (years <= 19) {
                price -= price * 0.2;
            }
            if (moneyHave >= price) {
                System.out.printf("You purchased a 1 month pass for %s.", sport);

            } else {
                System.out.printf("You don't have enough money! You need $%.2f more.", Math.abs(moneyHave - price));
            }
        }
    }
}