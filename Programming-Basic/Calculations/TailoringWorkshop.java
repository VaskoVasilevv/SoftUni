import java.util.Scanner;

public class TailoringWorkshop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tables = Integer.parseInt(scanner.nextLine());
        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());

        double carpetsAreaForOneTable = ((length + 0.60) * (width + 0.60));
        double totalCarpetAre = carpetsAreaForOneTable * tables;
        double careside = length / 2;
        double totalCareAreaForOneTable = (careside * careside);
        double totalCareArea = totalCareAreaForOneTable * tables;

        double usd = totalCarpetAre * 7 + totalCareArea * 9;
        double bgn = usd * 1.85;

        System.out.printf("%.2f USD%n", usd);
        System.out.printf("%.2f BGN", bgn);
    }
}