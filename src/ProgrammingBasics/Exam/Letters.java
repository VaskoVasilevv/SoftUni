package ProgrammingBasics.Exam;

import java.util.Scanner;

public class Letters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char first = scanner.nextLine().charAt(0);
        char second = scanner.nextLine().charAt(0);
        char third = scanner.nextLine().charAt(0);
        int counter = 0;

        for (char i = first; i <= second; i++) {
            if (i == third){
                continue;
            }
            for (int j = first; j <= second ; j++) {
                if (j== third){
                    continue;
                }
                for (int k = first; k <= second ; k++) {
                    if (k == third){
                        continue;
                    }
                    System.out.printf("%c%c%c ",i,j,k);
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
}
