package Data.Types;

import java.util.Scanner;

public class FloatingEqualityMoreEX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());

        final double end = 0.000001F;

        if (Math.abs(a-b) >= end){
            System.out.println("False");
        }else {
            System.out.println("True");
        }


    }
}
