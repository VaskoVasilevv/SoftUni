package ProgrammingBasics.Exam;

import java.util.Scanner;

public class WeddingSeats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char sector = scanner.nextLine().charAt(0);
        int red = Integer.parseInt(scanner.nextLine());
        int mesta = Integer.parseInt(scanner.nextLine());
        int counter = 0;

        for (char i = 'A'; i <= sector; i++) {
            for (int j = 1; j <= red; j++) {
                if (j % 2 != 0) {
                    for (char k = 'a'; k < 'a'+ mesta; k++) {

                        System.out.printf("%c%d%c%n", i, j, k);
                        counter++;
                    }
                }else if (j % 2 == 0){
                    for (int k = 'a'; k < 'a' + 2 + mesta; k++) {
                        System.out.printf("%c%d%c%n", i, j, k);
                        counter++;
                    }
                }
            }
            red++;
        }
        System.out.println(counter);
    }
}
