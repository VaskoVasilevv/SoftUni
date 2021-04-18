package ProgrammingBasics.LastProjeckt;

import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int minNUm = Integer.MAX_VALUE;
        int i = 0;

        while (i < n){
            int number = Integer.parseInt(scanner.nextLine());

            if (number < minNUm){
                minNUm = number;
            }
            i++;
        }
        System.out.println(minNUm);
    }
}
