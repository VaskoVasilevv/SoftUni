package LastProjeckt;

import java.util.Scanner;

public class Scolaship {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());
        double c = Double.parseDouble(scanner.nextLine());
        double socialstipend = c * 0.35;
        double stipend = b * 25;

        if (a > c && b < 5.5) {
            System.out.println("You cannot get a scholarship!");
        }
        if (b >= 5.5) {
            System.out.printf("You get a scholarship for excellent result %.0f", Math.floor(stipend));
        }
        if (socialstipend > stipend) {
            System.out.printf("You get a Social scholarship %.0f BGN", socialstipend);
        } else if (a < c && b > 4.5) {
            if (socialstipend > stipend) {
                System.out.printf("You get a Social scholarship %.0f BGN", socialstipend);
            }
        }

    }
}



