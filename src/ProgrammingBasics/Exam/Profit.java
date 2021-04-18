package ProgrammingBasics.Exam;

import java.util.Scanner;

public class Profit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int moneti1 = Integer.parseInt(scanner.nextLine());
        int moneti2 = Integer.parseInt(scanner.nextLine());
        int leva5 = Integer.parseInt(scanner.nextLine());
        int sum = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= moneti1 ; i++) {
            for (int j = 0; j <= moneti2 ; j++) {
                for (int k = 0; k <= leva5 ; k++) {
                    if (i * 1 + j * 2 + k * 5 == sum){
                        System.out.printf("%d * 1 lv. + %d * 2 lv. + %d * 5 lv. = %d lv.%n",i,j,k,sum);
                    }
                }
            }
        }
        
    }
}
