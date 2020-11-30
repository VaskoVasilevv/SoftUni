import java.util.Scanner;

public class HappyCatParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int houers = Integer.parseInt(scanner.nextLine());
        double total1 = 0;
        for (int i = 1; i <= days ; i++) {
            double total = 0;
            for (int j = 1; j <= houers ; j++) {
                if (i % 2 == 0 && j % 2 != 0){
                    total += 2.5;
                    total1 += 2.5;
                }else if (i % 2 != 0 && j % 2 ==0){
                    total += 1.25;
                    total1 += 1.25;
                }else {
                    total += 1;
                    total1 += 1;
                }
            }
            System.out.printf("Day: %d - %.2f leva%n",i,total);
        }
        System.out.printf("Total: %.2f leva",total1);
    }
}
