package Exam;

import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sumata = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        int vuzrast = Integer.parseInt(scanner.nextLine());
        String sport = scanner.nextLine();
        double price = 0;

        switch (input) {
            case "m":
                switch (sport) {
                    case "Gym":
                        if (vuzrast <= 19) {
                            price = 42 - 42 * 0.2;
                        } else {
                            price = 42;
                        }
                        if (price <= sumata) {
                            System.out.printf("You purchased a 1 month pass for %s.",sport);

                            break;
                        } else {
                            price = price - sumata;
                            System.out.printf("You don't have enough money! You need $%.2f more.", price);
                        }
                        break;
                    case "Boxing":
                        if (vuzrast <= 19) {
                            price = 41 - 41 * 0.2;
                        } else {
                            price = 41;
                        }
                        if (price <= sumata) {
                            System.out.printf("You purchased a 1 month pass for %s.",sport);

                            break;
                        } else {
                            price = price - sumata;
                            System.out.printf("You don't have enough money! You need $%.2f more.", price);
                        }
                        break;
                    case "Yoga":
                        if (vuzrast <= 19) {
                            price = 45 - 45 * 0.2;
                        } else {
                            price = 45;
                        }
                        if (price <= sumata) {
                            System.out.printf("You purchased a 1 month pass for %s.",sport);

                            break;
                        } else {
                            price = price - sumata;
                            System.out.printf("You don't have enough money! You need $%.2f more.", price);
                        }
                        break;
                    case "Zumba":
                        if (vuzrast <= 19) {
                            price = 34 - 34 * 0.2;
                        } else {
                            price = 34;
                        }
                        if (price <= sumata) {
                            System.out.printf("You purchased a 1 month pass for %s.",sport);

                            break;
                        } else {
                            price = price - sumata;
                            System.out.printf("You don't have enough money! You need $%.2f more.", price);
                        }
                        break;
                    case "Dances":
                        if (vuzrast <= 19) {
                            price = 51 - 51 * 0.2;
                        } else {
                            price = 51;
                        }
                        if (price <= sumata) {
                            System.out.printf("You purchased a 1 month pass for %s.",sport);

                            break;
                        } else {
                            price = price - sumata;
                            System.out.printf("You don't have enough money! You need $%.2f more.", price);
                        }
                        break;
                    case "Pilates":
                        if (vuzrast <= 19) {
                            price = 39 - 39 * 0.2;
                        } else {
                            price = 39;
                        }
                        if (price <= sumata) {
                            System.out.printf("You purchased a 1 month pass for %s.",sport);

                            break;
                        } else {
                            price = price - sumata;
                            System.out.printf("You don't have enough money! You need $%.2f more.", price);
                        }
                        break;
                }
                break;
            case "f":
                switch (sport) {
                    case "Gym":
                        if (vuzrast <= 19) {
                            price = 35 - 35 * 0.2;

                        } else {
                            price = 35;
                        }
                        if (price <= sumata) {
                            System.out.printf("You purchased a 1 month pass for %s.",sport);

                            break;
                        } else {
                            price = price - sumata;
                            System.out.printf("You don't have enough money! You need $%.2f more.", price);
                        }
                        break;
                    case "Boxing":
                        if (vuzrast <= 19) {
                            price = 37 - 37 * 0.2;

                        } else {
                            price = 37;
                        }
                        if (price <= sumata) {
                            System.out.printf("You purchased a 1 month pass for %s.",sport);

                            break;
                        } else {
                            price = price - sumata;
                            System.out.printf("You don't have enough money! You need $%.2f more.", price);
                        }
                        break;
                    case "Yoga":
                        if (vuzrast <= 19) {
                            price = 42 - 42 * 0.2;

                        } else {
                            price = 42;
                        }
                        if (price <= sumata) {
                            System.out.printf("You purchased a 1 month pass for %s.",sport);

                            break;
                        } else {
                            price = price - sumata;
                            System.out.printf("You don't have enough money! You need $%.2f more.", price);
                        }
                        break;
                    case "Zumba":
                        if (vuzrast <= 19) {
                            price = 31 - 31 * 0.2;

                        } else {
                            price = 31;
                        }
                        if (price <= sumata) {
                            System.out.printf("You purchased a 1 month pass for %s.",sport);

                            break;
                        } else {
                            price = price - sumata;
                            System.out.printf("You don't have enough money! You need $%.2f more.", price);
                        }
                        break;
                    case "Dances":
                        if (vuzrast <= 19) {
                            price = 53 - 53 * 0.2;
                        } else {
                            price = 53;
                        }
                        if (price <= sumata) {
                            System.out.printf("You purchased a 1 month pass for %s.",sport);

                            break;
                        } else {
                            price = price - sumata;
                            System.out.printf("You don't have enough money! You need $%.2f more.", price);
                        }
                        break;
                    case "Pilates":
                        if (vuzrast <= 19) {
                            price = 37 - 37 * 0.2;
                        } else {
                            price = 37;
                        }
                        if (price <= sumata) {
                            System.out.printf("You purchased a 1 month pass for %s.",sport);
                            break;
                        } else {
                            price =  price - sumata;
                            System.out.printf("You don't have enough money! You need $%.2f more.", price);
                        }
                        break;
                }
                break;
        }
    }
}
