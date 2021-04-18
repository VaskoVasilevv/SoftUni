package LastProjeckt;

import java.util.Scanner;

public class ExcellentResult {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budgetForFilm = Double.parseDouble(scanner.nextLine());
        int numOfStatist = Integer.parseInt(scanner.nextLine());
        double sumForDressOnOneStatist = Double.parseDouble(scanner.nextLine());

        double dekor = budgetForFilm * 0.1;
        double dressing = numOfStatist * sumForDressOnOneStatist;
        double sum = dekor + dressing;
        double otstupka = 0;

        if (sum <= budgetForFilm) {
            if (numOfStatist > 150) {
                otstupka = (dressing * 0.1);
            }
            double allotstupka = dressing - otstupka;
            double allSum = dekor + allotstupka;
            double total = budgetForFilm - allSum;
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", total);
        } else if (sum > budgetForFilm) {
            if (numOfStatist > 150) {
                otstupka = (dressing * 0.1);
            }
            double allotstupka = dressing - otstupka;
            double allSum = dekor + allotstupka;
            double total = allSum - budgetForFilm;
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", total);
        }
    }
}

