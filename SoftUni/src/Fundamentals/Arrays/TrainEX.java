package bg.softuni.fundamentals.Arrays;

import java.util.Scanner;

public class TrainEX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int [] peoole = new int[n];
        int sum = 0;
        for (int i = 0; i < peoole.length; i++) {
            peoole[i] = scanner.nextInt();
            System.out.print(peoole[i] + " ");
            sum += peoole[i];
        }
        System.out.println();
        System.out.println(sum);

    }
}
