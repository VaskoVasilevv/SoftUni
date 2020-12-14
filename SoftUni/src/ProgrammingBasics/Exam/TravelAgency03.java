import java.util.Scanner;

public class TravelAgency03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String paket = scanner.nextLine();
        String vip = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());
        double price = 0;
        boolean flag = false;

        switch (name) {
            case "Borovets":
            case "Bansko":
                switch (paket) {
                    case "noEquipment":
                        price += 80;
                        if (vip.equals("yes")) {
                            price -= price * 0.05;
                        }
                        break;
                    case "withEquipment":
                        price += 100;
                        if (vip.equals("yes")) {
                            price -= price * 0.1;
                        }
                        break;
                }
                break;
            case "Varna":
            case "Burgas":
                switch (paket) {
                    case "noBreakfast":
                        price += 100;
                        if (vip.equals("yes")) {
                            price -= price * 0.07;
                        }
                        break;
                    case "withBreakfast":
                        price += 130;
                        if (vip.equals("yes")) {
                            price -= price * 0.12;
                        }
                        break;
                    default:
                        flag = true;
                        break;
                }
                break;
            default:
                flag = true;
                break;
        }
        if (days > 7) {
            days -= 1;
        }
        if (flag) {
            System.out.println("Invalid input!");
        } else if (days < 1) {
            System.out.println("Days must be positive number!");
        } else {
            double price1 = price * days;
            System.out.printf("The price is %.2flv! Have a nice time!", price1);
        }
    }
}
