import java.util.Scanner;

public class FoodForPets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double days = Integer.parseInt(scan.nextLine());
        double food = Double.parseDouble(scan.nextLine());

        double sumDogFood = 0;
        double sumCatFood = 0;
        double biscuits = 0;
        double sumFood = 0;

        for (int i = 1; i <= days; i++) {
            double dogFood = Double.parseDouble(scan.nextLine());
            double catFood = Double.parseDouble(scan.nextLine());
            sumDogFood += dogFood;
            sumCatFood += catFood;
            sumFood += dogFood + catFood;
            if (i % 3 == 0) {
                biscuits += (dogFood + catFood) * 0.1;
            }
        }

        System.out.printf("Total eaten biscuits: %.0fgr.%n", biscuits);
        System.out.printf("%.2f%% of the food has been eaten.%n", sumFood / food * 100);
        System.out.printf("%.2f%% eaten from the dog.%n", sumDogFood / sumFood * 100);
        System.out.printf("%.2f%% eaten from the cat.%n", sumCatFood / sumFood * 100);
    }
}