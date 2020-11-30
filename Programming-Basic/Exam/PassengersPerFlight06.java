import java.util.Scanner;

public class PassengersPerFlight06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int abv = Integer.MIN_VALUE;
        String putniciAsString = "";
        String topCompany = "";
        int end = 0;

        for (int i = 1; i <= n; i++) {
            String name = scanner.nextLine();
            putniciAsString = scanner.nextLine();
            int totoal = 0;
            int counter = 0;

            while (!putniciAsString.equals("Finish")) {
                counter++;
                int putnici = Integer.parseInt(putniciAsString);
                totoal += putnici;
                end = totoal / counter;
                putniciAsString = scanner.nextLine();
            }
            System.out.printf("%s: %d passengers.%n", name, end);
            if ( end > abv) {
                abv = end;
                topCompany = name;
            }
        }
        System.out.printf("%s has most passengers per flight: %d",topCompany,abv);

    }
}



