import java.util.Scanner;

public class AgencyProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int old = Integer.parseInt(scanner.nextLine());
        int kid = Integer.parseInt(scanner.nextLine());
        double priceOld = Double.parseDouble(scanner.nextLine());
        double priceObslujvane = Double.parseDouble(scanner.nextLine());

        double kidPrice = priceOld * 0.3 + priceObslujvane;
        double oldPrice = priceOld + priceObslujvane;
        double priceForAll = kidPrice * kid + oldPrice * old ;
        double pechalba = priceForAll * 0.2;

        System.out.printf("The profit of your agency from %s tickets is %.2f lv.",name,pechalba);
    }
}
