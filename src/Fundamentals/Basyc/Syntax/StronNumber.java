package Fundamentals.Basyc.Syntax;

import java.util.Scanner;

public class StronNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int sum = 0;

        for (int i = 0; i < input.length(); i++) {
            int digit = input.charAt(i) - 48;

            int fuct = 1;
            for (int j = 1; j <= digit ; j++) {
                fuct *= j;
            }
            sum += fuct;
        }
        int inpuNum = Integer.parseInt(input);
        if (sum == inpuNum){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }
}

