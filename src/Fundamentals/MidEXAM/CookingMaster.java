package Fundamentals.MidEXAM;

import java.util.Scanner;

public class CookingMaster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceOfFlor = Double.parseDouble(scanner.nextLine());
        double priceOfEgg = Double.parseDouble(scanner.nextLine());
        double priceOfApron = Double.parseDouble(scanner.nextLine());

        double sum = 0;
        double freePakat = 0;
        for (int i = 1; i <= students; i++) {
            if (i % 5 == 0){
                freePakat ++;
            }
        }
        sum = priceOfApron * (Math.ceil(students * 1.2)) + priceOfEgg * 10 * (students) + priceOfFlor * (students - freePakat);


        if (sum <= budget) {
            System.out.printf("Items purchased for %.2f$.", sum);
        }else {
            double sum1 = sum - budget;
            System.out.printf("%.2f$ more needed.",sum1);
        }
    }
}
