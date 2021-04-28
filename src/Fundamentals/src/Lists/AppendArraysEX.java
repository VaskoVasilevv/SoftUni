package Lists;

import java.util.Scanner;

public class AppendArraysEX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arrays = scanner.nextLine().split("\\|");
        String result = "";
        for (int i = arrays.length - 1; i >= 0; i--) {
            String[] courrentAr = arrays[i].split("\\s+");
            for (int j = 0; j < courrentAr.length; j++) {
                if (!courrentAr[j].equals("")) {
                    result += courrentAr[j] + " ";
                }
            }

        }
        System.out.print(result.trim());

    }
}
