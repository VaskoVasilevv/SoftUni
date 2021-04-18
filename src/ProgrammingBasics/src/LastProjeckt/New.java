package LastProjeckt;

import java.util.Scanner;

public class New {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        int b = 1;
        double total = 0;

        while (n >= b){
            double courentSum = Double.parseDouble(scanner.nextLine());
            if (courentSum < 0){
                System.out.println("Invalid operation!");
                break;
            }
            total += courentSum;
            b++;
            System.out.printf("Increase: %.2f",courentSum);
        }
        System.out.printf("Total: %.2f",total);
    }
}
