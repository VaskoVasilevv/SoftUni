package ProgrammingBasics.Calculations;

import java.util.Scanner;

public class CharityCampaign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int sladkar = Integer.parseInt(scanner.nextLine());
        int torti = Integer.parseInt(scanner.nextLine());
        int gofreti = Integer.parseInt(scanner.nextLine());
        int palachinki = Integer.parseInt(scanner.nextLine());

        double broitorti = torti * 45;
        double broigofreti = gofreti * 5.80;
        double broipalachinki = palachinki * 3.20;

        double priceforOneDay = (broitorti + broigofreti + broipalachinki) * sladkar;
        double sumforallcampany = priceforOneDay * days ;

        double  sumafterrazhodi = sumforallcampany  - (sumforallcampany/8);

        System.out.printf("%.2f",sumafterrazhodi);

    }
}
