package ProgrammingBasics.Exam;

import java.util.Scanner;

public class Logistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfTovar = Integer.parseInt(scanner.nextLine());
        double allTon = 0;
        double mictobus = 0;
        double mictobusSum = 0;
        double kamion = 0;
        double kamionSum = 0;
        double vlak = 0;
        double vlakSum = 0;

        for (int i = 1; i <= numberOfTovar ; i++) {
            int ton = Integer.parseInt(scanner.nextLine());
            allTon += ton;
            if (ton <= 3){
                mictobusSum += ton;
                mictobus += ton * 200;
            }else if (ton > 3 && ton <= 11){
                kamionSum += ton;
                kamion += ton * 175;
            }else {
                vlakSum += ton;
                vlak += ton * 120;
            }
        }
        double sredno = (mictobus + kamion + vlak ) / allTon;
        System.out.printf("%.2f%n",sredno);
        System.out.printf("%.2f%%%n",mictobusSum / allTon * 100);
        System.out.printf("%.2f%%%n",kamionSum / allTon * 100);
        System.out.printf("%.2f%%%n",vlakSum / allTon * 100);

    }
}
