import java.util.Scanner;

public class DivisionWithoutRemainder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int byTwo = 0;
        int byTree = 0;
        int byFour = 0;

        int numbers = Integer.parseInt(scanner.nextLine());


        for (int i = 1; i <= numbers; i++) {
            int currentNumber = Integer.parseInt(scanner.nextLine());
            if (currentNumber % 2 == 0) {
                byTwo++;
            }
            if (currentNumber % 3 == 0) {
                byTree++;
            }
            if (currentNumber % 4 == 0) {
                byFour++;
            }

        }
        System.out.printf("%,.2f%%%n", byTwo * 1.0 / numbers * 100);
        System.out.printf("%,.2f%%%n", byTree * 1.0 / numbers * 100);
        System.out.printf("%,.2f%%%n", byFour * 1.0 / numbers * 100);
    }
}
