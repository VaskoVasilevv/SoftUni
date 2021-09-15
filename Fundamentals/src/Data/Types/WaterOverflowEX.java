package Data.Types;

import java.util.Scanner;

public class WaterOverflowEX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int sutotalLitters = 0;
        for (int i = 0; i < n; i++) {
            int currentLiters = Integer.parseInt(scanner.nextLine());

            if (currentLiters + sutotalLitters > 255){
                System.out.println("Insufficient capacity!");
            }else {
                sutotalLitters += currentLiters;
            }


        }
        System.out.println(sutotalLitters);
    }
}
