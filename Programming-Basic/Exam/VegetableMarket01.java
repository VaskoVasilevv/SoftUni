import java.util.Scanner;

public class VegetableMarket01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double vegetable = Double.parseDouble(scanner.nextLine());
        double fruit = Double.parseDouble(scanner.nextLine());
        int kgvegetable = Integer.parseInt(scanner.nextLine());
        int kgFruit = Integer.parseInt(scanner.nextLine());

        double result = vegetable * kgvegetable + fruit * kgFruit;

        System.out.printf("%.2f",result / 1.94);
    }
}
