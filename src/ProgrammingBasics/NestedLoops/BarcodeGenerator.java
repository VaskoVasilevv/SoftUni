package ProgrammingBasics.NestedLoops;

import java.util.Scanner;

public class BarcodeGenerator {
    public static void main(String[] args) {


        //Не работи !!!!!!!!!!!!!!!!! ГРЕШНО РЕШЕНИЕ !!!!!

        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        boolean flag = false;

        for (int i = a; i <= b; i++) {
            String courentNum = "" + i;
            for (int j = 0; j < courentNum.length(); j++) {
                int courrentDigit = Integer.parseInt("" + courentNum.charAt(j));

                if (j % 2 == 1 && i % 2 == 1) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}


