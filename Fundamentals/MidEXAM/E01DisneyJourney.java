package bg.softuni.fundamentals.MidEXAM;

import java.util.Scanner;

public class E01DisneyJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceForJourney = Double.parseDouble(scanner.nextLine());
        int months = Integer.parseInt(scanner.nextLine());
        double colected = 0;
        double bomus = 0;

        for (int i = 1; i <= months; i++) {
            if ( i % 2 != 0 && i != 1 ) {
                colected -= colected * 0.16;
            } else if (i % 4 == 0) {
                colected += colected * 0.25;

            }
            colected += priceForJourney * 0.25;


        }
        if (colected >= priceForJourney) {
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.", colected - priceForJourney);
        } else {
            System.out.printf("Sorry. You need %.2flv. more.", priceForJourney - colected);
        }
    }
}
